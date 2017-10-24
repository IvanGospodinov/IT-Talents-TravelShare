package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Post {

	private int postId;
	private String category;
	private String title;
	private String location;
	private String description;

	private LocalDateTime dateTime;
	private LocalDateTime dateTime_modification;
	private LocalDate upload;
	private LocalDate modify;
	
	private User user;
	
	//INSERT INTO `travel-share`.posts VALUES (null, 'rrr','rrr','2017-10-22 22:53:06','2017-10-22 22:53:06',1,1,'rrr')
	
	private int user_id=1;
	private int category_id=1;

	private Set<Attachment> attachments=new HashSet<Attachment>() ;
	private Set<Coment> coments=new HashSet<Coment>() ;
	private Map<Emotion, Integer> emotions=new HashMap<Emotion, Integer>();

	
	
	
	public Post(String title, String location, String description) {
		super();
		this.title = title;
		this.location = location;
		this.description = description;
	}



	public Post(String title, String description, LocalDateTime dateTime, LocalDateTime dateTime_modification, int user_id, int category_id, String location) {
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.dateTime_modification = dateTime_modification;
		this.user_id = user_id;
		this.category_id = category_id;
		this.location = location;
		
	}
	
	
	
	public Post(String title, String description, LocalDate a, LocalDate b, int user_id, int category_id, String location) {
		this.title = title;
		this.description = description;
		this.upload = a;
		this.modify = b;
		this.user_id = user_id;
		this.category_id = category_id;
		this.location = location;
		
	}
	
	
	
	
	
//	public Post(String title, String category, String location, String description) {
//		this.category = category;
//		this.title = title;
//		this.location = location;
//		this.description = description;
//	}
//	
//	
//	public Post(String title, String description) {
//		this.title = title;
//		this.description = description;
//	}
//	
//
//	public Post(String category, String title, String location, String description, LocalDateTime dateTime) {
//		this.category = category;
//		this.title = title;
//		this.location = location;
//		this.description = description;
//		this.dateTime = dateTime;
//	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Post(String title, String description, LocalDateTime dateTime, User user) {
		this.description = title;
		this.description = description;
		this.dateTime = dateTime;
		this.user = user;
	}

//	public Post(String title, String description, LocalDateTime dateTime, User user, HashSet<Attachment> attachments,
//			HashSet<Coment> coments, Map<Emotion, Integer> emotions) {
//		this(title, description, dateTime, user);
//
//		this.attachments = attachments;
//		this.coments = coments;
//		this.emotions = emotions;
//	}




	public void setPostId(int post_id) {
		this.postId = post_id;
	}

	
	
	public int getPostId() {
		return postId;
	}

	public String getDescription() {
		return description;
	}

//	public LocalDateTime getDateTime() {
//		return dateTime;
//	}

//	public User getUser() {
//		return user;
//	}

	public String getTitle() {
		return title;
	}

//	public Set<Attachment> getAttachments() {
//		return attachments;
//	}
//
//	public Set<Coment> getComents() {
//		return coments;
//	}
//
//	public Map<Emotion, Integer> getEmotions() {
//		return emotions;
//	}

}
