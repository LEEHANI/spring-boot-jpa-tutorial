package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.impl.UserRepositorySupport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDslTest {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

    @Autowired
    private UserRepositorySupport academyRepositorySupport;

//    @After
    public void tearDown() throws Exception {
    	userRepository.deleteAllInBatch();
    }

//    @Test
    public void querydsl_basic() {
        //given
    	String name = "may";
        String address = "rorean@naver.com";
        userRepository.save(User.builder().name(name).address(address).build());
        
        String name2 = "may2";
        String address2 = "rorean@naver.com";
        userRepository.save(User.builder().name(name2).address(address2).build());
    	
        //when
        List<User> result = userRepository.findByName("may");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is("rorean@naver.com"));
    }
    
    @Test
    public void querydsl_relation()
    {
    	//given
    	String name = "may";
        String address = "rorean@naver.com";
        User user1 = User.builder().name(name).address(address).build();
        String content = "포스팅~";
        user1.bind(Post.builder().content(content).build());
        userRepository.save(user1);
        
        String name2 = "may2";
        String address2 = "rorean@naver.com";
        userRepository.save(User.builder().name(name2).address(address2).build());
        userRepository.save(User.builder().name(name2).address(address2).build());
        
    	
    	//when
    	List<Post> result = postRepository.findByContent(content);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getContent(), is("포스팅~"));
        assertThat(result.get(0).getUser().getAddress(), is("rorean@naver.com"));
    }
}
