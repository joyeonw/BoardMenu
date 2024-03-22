package com.board.menus.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.menus.domain.MenuVo;

import ch.qos.logback.core.model.Model;

@Mapper
public interface MenuMapper {

	//void insertMenu(String menu_id, String menu_name, int menu_seq);

	List<MenuVo> getMenuList();

	void insertMenu( MenuVo menuVo );

	void deleteMenu(MenuVo menuVo);

	void insertMenuByName(MenuVo menuVo);

	void updateMenu(MenuVo menuVo);

	MenuVo getMenu(String menu_id);

	

	
	
}
