package com.test.web.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor(staticName= "on")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Tag //extends AbstractAuditing
{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TagPrimaryKey tagPK;
	
//	@NonNull
//	@Column(name = "title", nullable = false, updatable = true)
//	private String title;
	
	@Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tag", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<PostTag> postTags = new HashSet<PostTag>();
}
