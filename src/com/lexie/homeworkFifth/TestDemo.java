package com.lexie.homeworkFifth;

import java.util.Scanner;

public class TestDemo {
	Song song = new Song();
	Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	PlayList pl = new PlayList();
	PlayList pll = new PlayList();
	PlayListCollection plc = new PlayListCollection();
	
	//测试歌曲类
	public void testSong() {
		Song song = new Song("s001","Mean","Taylor");
		System.out.println(song);
	}
	
	//测试播放列表类
	public void testPlayList() {
		
		System.out.println("请选择添加到哪个播放列表：");
		pl.addToPlayList(song);
		pl.displayAllSong();
		System.out.println("请输入您要查询的歌曲的id：");
		System.out.println(pl.searchSongById(scan.nextLine()));
		System.out.println("请输入您要查询的歌曲的名称：");
		System.out.println(pl.searchSongByName(scan.nextLine()));
		System.out.println("请输入您要修改的歌曲的id：");
		pl.updateSong(scan.nextLine(), song);
		System.out.println("请输入您要删除的歌曲的id：");
		pl.deleteSong(scan.nextLine());
		pl.exportPlayList();
	}
	
	//测试播放器类
	public void testPlayListCollection() {
		plc.addPlayList(pl);
		plc.deletePlayList(pl);
		System.out.println("请输入您要查询的播放列表的名字：");
		System.out.println(plc.searchPlayListByName(scan.nextLine()));
		plc.displayPlayListName();
	}
	
	//主菜单
	public void mainMenu() {
		System.out.println("***************************");
		System.out.println("          **主菜单**          ");
		System.out.println("        1--播放列表管理                                ");
		System.out.println("        2--播放器管理                                ");
		System.out.println("        0--退出                               ");
		System.out.println("***************************");
		System.out.println("请输入对应数字进行操作：");
	}
	
	//播放列表管理菜单
	public void playListMenu() {
		boolean flag = true;
		while(flag) {
		System.out.println("***************************");
		System.out.println("       **播放列表管理**        ");
		System.out.println("    1--将歌曲添加到主播放列表                  ");
		System.out.println("    2--将歌曲添加到普通播放列表              ");
		System.out.println("    3--通过歌曲id查询播放列表中的歌曲  ");
		System.out.println("    4--通过歌曲名称查询播放列表中的歌曲  ");
		System.out.println("    5--修改播放列表中的歌曲  ");
		System.out.println("    6--删除播放列表中的歌曲  ");
		System.out.println("    7--显示播放列表中的所有歌曲  ");
		System.out.println("    8--导出歌单  ");
		System.out.println("    9--返回上一级菜单  ");
		System.out.println("***************************");
		System.out.println("请输入对应数字对播放列表进行管理：");
		int n2 = scan.nextInt();
		switch(n2) {
		case 1: 
			pl.setPlayListName("主播放列表");
			pl.addToPlayList(song);
			break;
		case 2:
			System.out.println("请为普通播放列表取个名字：");
			pll.setPlayListName(scan2.nextLine());
			pll.addToPlayList(song);
			break;
		case 3:
			System.out.println("请输出您要查询的播放列表的名称：");
			String s1 = scan1.nextLine();
			if(s1.equals(pl.getPlayListName())) {
				System.out.println("请输入您要查询的歌曲的id：");
				System.out.println(pl.searchSongById(scan2.nextLine()));
			}else if(s1.equals(pll.getPlayListName())) {
				System.out.println("请输入您要查询的歌曲的id：");
				System.out.println(pll.searchSongById(scan2.nextLine()));
			}
			break;
		case 4:
			System.out.println("请输出您要查询的播放列表的名称：");
			String s2 = scan1.nextLine();
			if(s2.equals(pl.getPlayListName())) {
				System.out.println("请输入您要查询的歌曲的名称：");
				System.out.println(pl.searchSongByName(scan2.nextLine()));
			}else if(s2.equals(pll.getPlayListName())) {
				System.out.println("请输入您要查询的歌曲的名称：");
				System.out.println(pll.searchSongByName(scan2.nextLine()));
			}
			break;
		case 5:
			System.out.println("请输出您要修改的播放列表的名称：");
			String s3 = scan1.nextLine();
			if(s3.equals(pl.getPlayListName())) {
				System.out.println("请输入您要修改的歌曲的id：");
				pl.updateSong(scan2.nextLine(), song);
			}else if(s3.equals(pll.getPlayListName())) {
				System.out.println("请输入您要修改的歌曲的id：");
				pl.updateSong(scan2.nextLine(), song);
			}
			break;
		case 6:
			System.out.println("请输出您要删除的播放列表的名称：");
			String s4 = scan1.nextLine();
			if(s4.equals(pl.getPlayListName())) {
				System.out.println("请输入您要删除的歌曲的id：");
				pl.deleteSong(scan2.nextLine());
			}else if(s4.equals(pll.getPlayListName())) {
				System.out.println("请输入您要删除的歌曲的id：");
				pll.deleteSong(scan2.nextLine());
			}
			break;
		case 7:
			pl.displayAllSong();
			pll.displayAllSong();
			break;
		case 8:
			pl.exportPlayList();
			pll.exportPlayList();
			System.out.println("导出成功！");
			break;
		case 9:
			flag = false;
			this.test();
			break;
		default:
			System.out.println("输入错误！请重新输入!");
			break;
		}
		}
	}
	
	//播放器菜单
	public void playerMenu() {
		boolean flag = true;
		while(flag) {
		System.out.println("***************************");
		System.out.println("       **播放器管理**        ");
		System.out.println("    1--向播放器添加播放列表                  ");
		System.out.println("    2--从播放器删除播放列表              ");
		System.out.println("    3--通过名字查询播放列表信息  ");
		System.out.println("    4--显示所有播放列表名称  ");
		System.out.println("    9--返回上一级菜单  ");
		System.out.println("***************************");
		System.out.println("请输入对应数字对播放器进行管理：");
		int n3 = scan.nextInt();
		switch (n3) {
		case 1:
			System.out.println("请输出您要添加的播放列表的名称：");
			String s0 = scan1.nextLine();
			if(s0.equals(pl.getPlayListName()))
				plc.addPlayList(pl);
			else if(s0.equals(pll.getPlayListName()))
				plc.addPlayList(pll);
			break;
		case 2:
			boolean flag2 = true;
			while(flag2) {
				System.out.println("请输出您要删除的播放列表的名称：");
				String s5 = scan1.nextLine();
				if(s5.equals(pl.getPlayListName())) {
					flag2 = false;
					plc.deletePlayList(pl);
				}
				else if(s5.equals(pll.getPlayListName())) {
					flag2 = false;
					plc.deletePlayList(pll);
				}
				else
					System.out.println("没找到该名字！请重新输入！");
			}
			break;
		case 3:
			System.out.println("请输入您要查询的播放列表的名字：");
			System.out.println(plc.searchPlayListByName(scan2.nextLine()));
			break;
		case 4:
			plc.displayPlayListName();
			break;
		case 9:
			flag = false;
			this.test();
			break;
		default:
			System.out.println("输入错误！请重新输入!");
			break;
		}
		}
	}
	
	//主流程实现
	public void test() {
		boolean flag = true;
		while(flag) {
			this.mainMenu();
			int n1 = scan.nextInt();
			switch(n1) {
			case 1:
				this.playListMenu();
				flag = false;
				break;
			case 2:
				this.playerMenu();
				flag = false;
				break;
			case 0:
				System.out.println("再见！");
				flag = false;
				break;
				default:
					System.out.println("输入错误！请重新输入!");
					break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDemo td = new TestDemo();
//		//测试歌曲类
//		td.testSong();
//		//测试播放列表类
//		td.testPlayList();
//		//测试播放器类
//		td.testPlayListCollection();
		
		//正式开始测试
		td.test();
	}
}
