CREATE TABLE `teacher` (
	`teacher_ID`	BIGINT	NOT NULL	COMMENT '선생님 정보',
	`organization`	VARCHAR(255)	NULL,
	`user_ID`	BIGINT	NOT NULL
);

CREATE TABLE `course` (
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`title`	VARCHAR(60)	NOT NULL	COMMENT '강좌 이름',
	`total__time`	TIME	NOT NULL	COMMENT '총 강좌 시간',
	`expiry_date`	DATETIME	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`status`	TINYINT(1)	NOT NULL,
	`level`	ENUM('입문', '초급', '중급이상')	NOT NULL	COMMENT '입문, 초급, 중급이상',
	`teacher_ID`	BIGINT	NOT NULL	COMMENT '선생님 정보'
);

CREATE TABLE `lecture` (
	`lecture_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(255)	NOT NULL,
	`running_time`	INT(6)	NOT NULL,
	`has_attachment`	TINYINT(1)	NOT NULL	COMMENT 'Y/N',
	`has_section`	TINYINT(1)	NOT NULL	COMMENT 'Y/N',
	`has_preview`	TINYINT(1)	NOT NULL	COMMENT 'Y/N',
	`section_ID`	BIGINT	NOT NULL	COMMENT '강의 정보'
);

CREATE TABLE `section` (
	`section_ID`	BIGINT	NOT NULL	COMMENT '강의 정보',
	`title`	VARCHAR(100)	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한'
);

CREATE TABLE `review` (
	`review_ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`rating`	FLOAT(4)	NOT NULL	COMMENT '아이디로 사용하는 이메일',
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_ID`	BIGINT	NOT NULL
);

CREATE TABLE `bookmark_teacher` (
	`bookmark_tch_ID`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`student_ID`	BIGINT	NOT NULL,
	`teacher_ID`	BIGINT	NOT NULL	COMMENT '선생님 정보'
);

CREATE TABLE `student` (
	`student_ID`	BIGINT	NOT NULL,
	`user_ID`	BIGINT	NOT NULL
);

CREATE TABLE `bookmark_course` (
	`bookmark_course_ID`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_ID`	BIGINT	NOT NULL
);

CREATE TABLE `attend_course` (
	`attend_course_ID`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`status`	TINYINT(1)	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_ID`	BIGINT	NOT NULL
);

CREATE TABLE `course_qna` (
	`course_qna_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_id`	BIGINT	NOT NULL,
	`lecture_ID`	BIGINT	NOT NULL
);

CREATE TABLE `course_qna_comment` (
	`course_qna_comment_ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`course_qna_ID`	BIGINT	NOT NULL,
	`writer_id`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_tasks` (
	`lecture_tasks_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`lecture_ID`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_quiz` (
	`lecture_quiz_ID`	BIGINT	NOT NULL,
	`quiz_title`	VARCHAR(255)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`lecture_ID`	BIGINT	NOT NULL
);

CREATE TABLE `board` (
	`board_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `quiz_participation` (
	`quiz_participation_ID`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`score`	TINYINT(1)	NOT NULL,
	`lecture_quiz_ID`	BIGINT	NOT NULL,
	`student_ID`	BIGINT	NOT NULL
);

CREATE TABLE `board_comment` (
	`board_comment_ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`board_ID`	BIGINT	NOT NULL,
	`writer_id`	BIGINT	NOT NULL
);

CREATE TABLE `tasks_attached_file` (
	`tasks_attached_file_ID`	BIGINT	NOT NULL,
	`original_file_name`	VARCHAR(255)	NOT NULL,
	`upload_file_name`	VARCHAR(255)	NOT NULL,
	`path`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NOT NULL,
	`lecture_tasks_ID`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_instructor` (
	`lecture_instructor_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`lecture_ID`	BIGINT	NOT NULL
);

CREATE TABLE `tasks_submit` (
	`tasks_submit_ID`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`lecture_tasks_ID`	BIGINT	NOT NULL,
	`student_ID`	BIGINT	NOT NULL
);

CREATE TABLE `tasks_submit_attached_file` (
	`tasks_submit_attached_file_ID`	BIGINT	NOT NULL,
	`original_file`	VARCHAR(255)	NOT NULL,
	`upload_file`	VARCHAR(255)	NOT NULL,
	`path`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NOT NULL,
	`tasks_submit_ID`	BIGINT	NOT NULL
);

CREATE TABLE `tutorials_attached_file` (
	`tutorials_attached_file_ID`	BIGINT	NOT NULL,
	`original_file_name`	VARCHAR(255)	NOT NULL,
	`upload_file_name`	VARCHAR(255)	NOT NULL,
	`path`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NOT NULL,
	`lecture_instructor_ID`	BIGINT	NOT NULL
);

CREATE TABLE `course_notice` (
	`course_notice_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`teacher_ID`	BIGINT	NOT NULL	COMMENT '선생님 정보'
);

CREATE TABLE `user` (
	`user_ID`	BIGINT	NOT NULL,
	`user_name`	VARCHAR(50)	NOT NULL,
	`email`	VARCHAR(255)	NOT NULL,
	`mobile_number`	VARCHAR(11)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`role`	INT(2)	NOT NULL,
	`introduction`	VARCHAR(255)	NULL
);

ALTER TABLE `teacher` ADD CONSTRAINT `PK_TEACHER` PRIMARY KEY (
	`teacher_ID`
);

ALTER TABLE `course` ADD CONSTRAINT `PK_COURSE` PRIMARY KEY (
	`course_ID`
);

ALTER TABLE `lecture` ADD CONSTRAINT `PK_LECTURE` PRIMARY KEY (
	`lecture_ID`
);

ALTER TABLE `section` ADD CONSTRAINT `PK_SECTION` PRIMARY KEY (
	`section_ID`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_ID`
);

ALTER TABLE `bookmark_teacher` ADD CONSTRAINT `PK_BOOKMARK_TEACHER` PRIMARY KEY (
	`bookmark_tch_ID`
);

ALTER TABLE `student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`student_ID`
);

ALTER TABLE `bookmark_course` ADD CONSTRAINT `PK_BOOKMARK_COURSE` PRIMARY KEY (
	`bookmark_course_ID`
);

ALTER TABLE `attend_course` ADD CONSTRAINT `PK_ATTEND_COURSE` PRIMARY KEY (
	`attend_course_ID`
);

ALTER TABLE `course_qna` ADD CONSTRAINT `PK_COURSE_QNA` PRIMARY KEY (
	`course_qna_ID`
);

ALTER TABLE `course_qna_comment` ADD CONSTRAINT `PK_COURSE_QNA_COMMENT` PRIMARY KEY (
	`course_qna_comment_ID`
);

ALTER TABLE `lecture_tasks` ADD CONSTRAINT `PK_LECTURE_TASKS` PRIMARY KEY (
	`lecture_tasks_ID`
);

ALTER TABLE `lecture_quiz` ADD CONSTRAINT `PK_LECTURE_QUIZ` PRIMARY KEY (
	`lecture_quiz_ID`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`board_ID`
);

ALTER TABLE `quiz_participation` ADD CONSTRAINT `PK_QUIZ_PARTICIPATION` PRIMARY KEY (
	`quiz_participation_ID`
);

ALTER TABLE `board_comment` ADD CONSTRAINT `PK_BOARD_COMMENT` PRIMARY KEY (
	`board_comment_ID`
);

ALTER TABLE `tasks_attached_file` ADD CONSTRAINT `PK_TASKS_ATTACHED_FILE` PRIMARY KEY (
	`tasks_attached_file_ID`
);

ALTER TABLE `lecture_instructor` ADD CONSTRAINT `PK_LECTURE_INSTRUCTOR` PRIMARY KEY (
	`lecture_instructor_ID`
);

ALTER TABLE `tasks_submit` ADD CONSTRAINT `PK_TASKS_SUBMIT` PRIMARY KEY (
	`tasks_submit_ID`
);

ALTER TABLE `tasks_submit_attached_file` ADD CONSTRAINT `PK_TASKS_SUBMIT_ATTACHED_FILE` PRIMARY KEY (
	`tasks_submit_attached_file_ID`
);

ALTER TABLE `tutorials_attached_file` ADD CONSTRAINT `PK_TUTORIALS_ATTACHED_FILE` PRIMARY KEY (
	`tutorials_attached_file_ID`
);

ALTER TABLE `course_notice` ADD CONSTRAINT `PK_COURSE_NOTICE` PRIMARY KEY (
	`course_notice_ID`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_ID`
);

