package kr.green.mvc5.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class MemoVO {
	private int idx;
	private String name;
	private String password;
	private String content;
	private Date   regDate = new Date();
	private String ip;
}
