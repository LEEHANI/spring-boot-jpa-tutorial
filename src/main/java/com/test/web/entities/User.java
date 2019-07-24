package com.test.web.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.web.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName= "on")
@Audited
public class User extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "user_id", nullable = false, updatable = false)
	private String userId;
	
	@NonNull
	@Column(name = "password", nullable = false, updatable = true)
	private String password;
	
	@Column(name = "name", nullable = true, updatable = true)
	private String name;
	
	@Column(name = "gender", nullable = true, updatable = true)
	private Gender gender;
	
	/**
	 * 1:1 단방향
	 */
	@NotAudited
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="membership_seq")
	private Membership membership;
	
	/**
	 * 1:1 양방향
	 * mappedBy : 관계를 소유 한 필드. 관계가 단방향이면 필수. 
	 */
	@NotAudited
	@OneToOne(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
//	@JoinColumn(name = "address_seq")
	@JsonManagedReference
	private Address address;
	
	/**
	 * 1:n 단방향
	 */
	@NotAudited
	@Default
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_seq")
	private Set<Phone> phones = new HashSet<Phone>();
	
	/**
	 * 1:n 양방향
	 */
	@NotAudited
	@Default
	@OneToMany(fetch = FetchType.EAGER, mappedBy="writer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Post> posts = new HashSet<Post>();
	
	public void  bind(Membership membership)
	{
		setMembership(membership);
	}
	
	public void bind(Address addres)
	{
		setAddress(addres);
		addres.setUser(this);
	}
	
	public void bind(Phone phone)
	{
		phones.add(phone);
	}
	
	public void bind(Post post)
	{
		posts.add(post);
		post.setWriter(this);
	}
	
}
