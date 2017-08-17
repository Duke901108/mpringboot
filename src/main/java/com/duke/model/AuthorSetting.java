package com.duke.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: duke
 * Date: 2017/8/9 下午8:00
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {
	private String age;
	private String gender;
}
