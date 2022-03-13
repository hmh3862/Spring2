package kr.green.mvc4.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Rss {
	private Channel channel;
	
	@Data
	@XmlRootElement
	public static class Channel{
		private String title;
		private String link;
		private String description;
		private List<Item> item;
		
	}
	
	@Data
	@XmlRootElement
	public static class Item{
		private String title;
		private String link;
		private String description;
		private String author;
		private String pubDate;
		private String image;
	}
}	
