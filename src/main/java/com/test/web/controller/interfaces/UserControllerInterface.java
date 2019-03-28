package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/user")
public interface UserControllerInterface
{
	@PostMapping("")
	public User insert(String userId, String password);
	
	@GetMapping("")
	public List<User> list();
	
//	@ApiOperation(value = "회원 조회")
//    @ApiImplicitParams
//    ({
//        @ApiImplicitParam(name = "seq", value = "PK", required = true, dataType = "long", paramType = "path", defaultValue = "")
//    })
	@GetMapping("{seq}")
	public User one(@PathVariable Long seq);
	
	@DeleteMapping("{seq}")
	public void delete(@PathVariable Long seq);
	
	@PutMapping("")
	public User changePassword(String userId, String password, String newPassword);
}
