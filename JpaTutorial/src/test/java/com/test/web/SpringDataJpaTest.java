package com.test.web;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Priority;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.web.configurations.JpaAuditingConfiguration;
import com.test.web.entities.Address;
import com.test.web.entities.Comment;
import com.test.web.entities.Membership;
import com.test.web.entities.Phone;
import com.test.web.entities.Post;
import com.test.web.entities.PostTag;
import com.test.web.entities.Tag;
import com.test.web.entities.User;
import com.test.web.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("loc")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Import(JpaAuditingConfiguration.class)
public class SpringDataJpaTest
{
	@Autowired
    private UserRepository userRepository;
	
	@Test
	public void oneToOne단방향()
	{
		//// 1:1 User To Membership
		User user = User.builder().userId("user1").password("pass1").build();
		user.setMembership(Membership.builder().point(9999).build());
		
		user = userRepository.save(user);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
	@Test
	public void oneToOne양방향()
	{
		//// 1:1 User To Address
		User user = User.builder().userId("user1").password("pass1").build();
		Address address = Address.builder().city("서울").street("테헤란로10길").build();
		
		user.setAddress(address);
		address.setUser(user);
		
		user = userRepository.save(user);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
	@Test
	public void oneToMany단방향()
	{
		//// 1:N User To Phone
		User user = User.builder().userId("user1").password("pass1").build();
		
		List<Phone> phones = Arrays.asList
								(
									Phone.builder().token("QOWHSMFM291827").number("01012345678").build(),
									Phone.builder().token("SDHQWROQW2HWE").number("01012093823").build()
								);
		
		user.setPhones(phones);
		
		user = userRepository.save(user);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
	@Test
	public void oneToMany양방향()
	{
		//// 1:N User To Post
		User user = User.builder().userId("user1").password("pass1").build();
		
		Post post1 = Post.builder().title("첫 포스트 입니다~").content("안녕하세요 잘 부탁드려요.").build();
		Post post2 = Post.builder().title("2빠 !!").content("아쉽게 2등이네요 ~!! 안녕하세요").build();
		
		post1.setWriter(user);
		post2.setWriter(user);
				
		List<Post> posts = Arrays.asList(post1, post2);
		
		user.setPosts(posts);
		
		user = userRepository.save(user);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
	@Test
	public void manyToMany변형()
	{
		//// N:N Post To Tag  
		//// 변형(1:N,N:1) 
		//// 1:N Post To PostTag, N:1 PostTag To Tag
		User user = User.builder().userId("user1").password("pass1").build();
		
		Post post1 = Post.builder().title("첫 포스트 입니다~").content("안녕하세요 잘 부탁드려요.").build();
		Post post2 = Post.builder().title("2빠 !!").content("아쉽게 2등이네요 ~!! 안녕하세요").build();
		
		Tag tag1 = Tag.builder().title("로맨틱").build();
		Tag tag2 = Tag.builder().title("환상적").build();
		
		PostTag postTag1 = PostTag.builder().tag(tag1).build();
		PostTag postTag2 = PostTag.builder().tag(tag2).build();
		PostTag postTag3 = PostTag.builder().tag(tag1).build();
		
		post1.bind(postTag1);
		post1.bind(postTag2);
		post2.bind(postTag3);
		
		user.bind(post1);
		user.bind(post2);
		
		user = userRepository.save(user);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
	@Test
	public void bindingTest()
	{
		User user = User.builder().userId("user11").password("passwd1").build();
		
		user.bind(Membership.builder().point(99999).build());
		user.bind(Address.builder().city("서울").street("중구 123-123").build());
		user.bind(Phone.builder().token("QKSJGO123WQJSDO@").number("01012345678").build());
		
		Post post = Post.builder().title("첫글!!!!!!").content("첫글 남겨요. 떨리네요").build();
		Tag tag1 =  Tag.builder().title("반갑").build();
		Tag tag2 =  Tag.builder().title("하이").build();
		
		PostTag postTag1 = PostTag.builder().post(post).tag(tag1).build();
		PostTag postTag2 = PostTag.builder().post(post).tag(tag2).build();
	
		post.bind(Comment.builder().content("첫댓글!!!").build());
		post.bind(postTag1);
		post.bind(postTag2);
		
		user.bind(post);
		
		user = userRepository.save(user);
	}
}
