package com.plestreet.community.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Table(name="board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"user"})
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardPkId;

	@Column(nullable = false)
	private String boardId;

	@Lob
	@Column(nullable = false)
	private String boardTitle;

	@Lob
	@Column(nullable = false)
	private String boardContent;

	@Lob
	private Blob boardImage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userPkId")
	private User user;

	// @Column(nullable = false)
	// @Enumerated(EnumType.STRING)
	// private State state;


	@Builder
	public Board(String boardId, String boardTitle, String boardContent, Blob boardImage, User user) {
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardImage = boardImage;
		this.user = user;
	}

	public void createBoard(String boardId, String boardTitle, String boardContent, Blob boardImage, User user){
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardImage = boardImage;
		this.user = user;
	}

	// public void setState(State state){
	// 	this.state = state;
	// }

	public void setUser(User user) {
		this.user = user;
	}

}