package com.test.web.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Post extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "title", nullable = false, updatable = false)
	private String title;
	
	@NonNull
	@Column(name = "content", nullable = false, updatable = false)
	private String content;
	
	@Column(name = "bigo", nullable = true, updatable = true)
	private String bigo;
	
	@ManyToOne
	@JoinColumn( name = "writer_seq", foreignKey = @ForeignKey(name = "FKEY_WRITER_SEQ_IN_PHONE"))
	@JsonBackReference
	private User writer;
	
	@Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy="post", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<PostTag> postTags = new HashSet<PostTag>();
	
	@Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy="post", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Comment> comments = new HashSet<Comment>();
	
	public void bind(PostTag postTag)
	{
		postTag.setPost(this);
		postTag.setTag(postTag.getTag());
		postTags.add(postTag);
	}
	
	public void bind(Comment comment)
	{
		comments.add(comment);
		comment.setPost(this);
	}
}
