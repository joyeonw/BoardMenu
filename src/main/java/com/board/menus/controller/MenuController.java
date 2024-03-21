package com.board.menus.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;




@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	// 메뉴 목록 조회
	@RequestMapping("/List")
	public String list(Model model) {
		// 조회 해서
		
		List<MenuVo> menuList = menuMapper.getMenuList();
		
		// 조회 결과를 넘겨준다 ( Model )
		model.addAttribute( "menuList", menuList );
		
		
		return "menus/list";
	}
	
	
	// 메뉴 입력받는 화면 /Menus/WriteForm
	//@RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")   // /Menus/Write
	public String writeForm() {
		return "menus/write"; //  /WEB-INF/views/ + menus/write + .jsp
   	}
	
	
	// 메뉴 저장
	// /Menus/Write?menu_id=&menu_name=&menu_seq=
	@RequestMapping("/Write")
	public String write( MenuVo menuVo, Model model ) {
		
		menuMapper.insertMenu( menuVo );
		return "redirect:/Menus/List";
//		List<MenuVo> menuList = menuMapper.getMenuList();
//		model.addAttribute("menuList", menuList);
//		
//		return "menus/list"; // menus/list. jsp
	}
	
	// 메뉴 삭제 //Menus/Delete?menu_id=MENU03
		@RequestMapping("/Delete")
		@ResponseBody
		public String delete( MenuVo menuvo ) {
			
			menuMapper.deleteMenu(menuvo);
			
			String html = "<script>";
			html	   += "alert('삭제되었습니다');";
			html       += "location.href='/Menus/List';";
			html       += "</script>";
			return html;
		}
	
	/*
	// 메뉴 삭제 //Menus/Delete?menu_id=MENU03
	@RequestMapping("/Delete")
	public String delete( MenuVo menuVo, Model model) {
		
		// MENU을 삭제
		menuMapper.deleteMenu( menuVo );
		
		return "redirect:/Menus/List";
		// 다시 조회해서 model에 담는다
//		List<MenuVo> menuList = menuMapper.getMenuList();
//		model.addAttribute("menuList", menuList);
		
		// 이동할 파일
//		return "menus/list";
	}
	*/
	
	
	
}
