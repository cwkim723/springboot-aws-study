package com.cwkim723.springbootstudy.web;

import com.cwkim723.springbootstudy.domain.posts.Posts;
import com.cwkim723.springbootstudy.domain.posts.PostsRepository;
import com.cwkim723.springbootstudy.web.dto.PostsSaveRequestDto;
import com.cwkim723.springbootstudy.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    // webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT -> 사용하지 않는 랜덤 포트를 사용하겠다

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    // REST 방식으로 개발한 API의 Test를 최적화 하기 위해 만들어진 클래스
    // HTTP 요청 후 데이터를 응답 받을 수 있는 템플릿 객체이며 ResponseEntity와 함께 자주 사용된다. Header와 Content-Type 등을 설정하여 API를 호출 할 수 있다.
    /*
        1. testRestTemplate.getForObject() - 기본 http 헤더를 사용하며 결과를 객체로 반환받는다.
        2. testRestTemplate.getForEntity() - 마찬가지로 기본 http 헤더를 사용하며 결과를 ResponseEntity로 반환받는다.
        3. testRestTemplate.exchange() - update할때 주로 사용된다. 결과를 ResponseEntity로 반환받는다. Http header를 변경할 수 있다.
    */

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{
        // given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder().title(title).content(content).author("author").build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        // postForEntity: POST 요청을 보내고 결과로 ResponseEntity로 반환받는다
        // https://advenoh.tistory.com/46

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void Posts_수정된다() throws Exception{
        // given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savedPosts.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder().title(expectedTitle).content(expectedContent).build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
        // HttpEntity: 이는 Http Request/Response가 이루어질 때 Http 헤더와 바디를 포함하는 클래스

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class);
        // 사용자의 HttpRequest에 대한 응답하는 데이터를 가진다.  Http Status, Header, Body를 포함

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}