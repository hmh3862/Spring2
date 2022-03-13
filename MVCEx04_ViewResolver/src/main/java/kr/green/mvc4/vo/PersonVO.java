package kr.green.mvc4.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name="person") // 루트태그이름
@XmlType(propOrder = {"birth","gender"}) // 태그가 나타나는 순서
@XmlAccessorType(XmlAccessType.FIELD) // 요소를 필드에 쓰겠다.
public class PersonVO {
	@XmlAttribute // 속성으로 쓰겠다.
	private String  name;
	@XmlElement   // 태그로 쓰겠다.
	@XmlJavaTypeAdapter(BirthAdapter.class)
	private Date    birth;
	@XmlElement(name="성별")
	@XmlJavaTypeAdapter(GenderAdapter.class)
	private Boolean gender;
}
