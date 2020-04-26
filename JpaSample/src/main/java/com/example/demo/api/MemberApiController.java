package com.example.demo.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RestController
@RequiredArgsConstructor
public class MemberApiController 
{
	private final MemberRepository memberRepository;
	private final MemberService memberService;
	
	@GetMapping("/api/v1/simple-members")
	public List<Member> findAll()
	{
		return memberRepository.findAll();
	}
	
	@GetMapping("/api/v2/simple-members")
	public List<MemberDto> findAll2()
	{
		List<Member> members = memberRepository.findAll();
		
		return members.stream().map(m->new MemberDto(m.getName(),m.getAddress())).collect(Collectors.toList());
	}
	
	@GetMapping("/api/v3/simple-members")
	public Response findAll3()
	{
		List<Member> members = memberRepository.findAll();
		
		List<MemberDto> memberDtos = members.stream().map(m->new MemberDto(m.getName(),m.getAddress())).collect(Collectors.toList());
		
		return Response.builder().data(memberDtos).build();
	}
	
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	public static class Response<T>
	{
		private T data;
	}
	
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	static class MemberDto
	{
		private String name;
		private Address address;
	}
	
	
	
	@PostMapping("/api/v1/member")
	public Long save(@RequestBody @Valid Member member)
	{
		Long id = memberRepository.save(member);
		
		return id;
	}
	
	@PostMapping("/api/v2/member")
	public CreateMemberResponse save2(@RequestBody @Valid CreateMemberRequest request)
	{
		Long id = memberRepository.save
				(
					Member.cretaeMember(request.getName(), null, null, null)
				);
		
		CreateMemberResponse response = new CreateMemberResponse(id);
		
		return response;
	}
	
	@PostMapping("/api/v2/member/{id}")
	public UpdateMemberResponse changeName
	(
		@PathVariable Long id,
		@RequestBody UpdateMemberRequest request
	)
	{
		Member m = memberService.update(id, request.getName());
		Member m2 = memberRepository.findById(id);
		System.out.println();
		m2.changeName("dlfmaqkRNsek");
		System.out.println();
		UpdateMemberResponse resposne = new UpdateMemberResponse(m.getId(), m.getName());
		return resposne;
	}
	
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	static class CreateMemberRequest
	{
		@NotNull
		private String name;
	}

	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	static class CreateMemberResponse
	{
		private Long memberId;
	}
	
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	static class UpdateMemberRequest
	{
		@NotNull
		private String name;
	}

	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Builder
	static class UpdateMemberResponse
	{
		private Long id;
		private String name;
	}
}
