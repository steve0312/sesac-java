CREATE TABLE `teacher` (
	`teacher_id`	BIGINT	NOT NULL	COMMENT '선생님 정보',
	`name`	VARCHAR(50)	NULL	COMMENT '선생님 이름',
	`email`	VARCHAR(255)	NOT NULL	COMMENT '아이디로 사용하는 이메일',
	`mobile_number`	VARCHAR(11)	NULL,
	`introduction`	VARCHAR(255)	NULL
);

CREATE TABLE `course` (
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`title`	VARCHAR(60)	NULL	COMMENT '강좌 이름',
	`total__time`	DATETIME	NULL	COMMENT '총 강좌 시간',
	`learn_able_limit`	DATETIME	NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`post_status`	TINYINT(1)	NULL,
	`level`	ENUM	NOT NULL	COMMENT '입문, 초급, 중급이상'
);

CREATE TABLE `lecture` (
	`lecture_id`	BIGINT	NOT NULL,
	`name`	VARCHAR(255)	NULL,
	`learn_time`	INT(6)	NULL,
	`file`	TINYINT(1)	NULL	COMMENT 'Y/N',
	`section`	TINYINT(1)	NULL	COMMENT 'Y/N',
	`preview`	TINYINT(1)	NULL	COMMENT 'Y/N',
	`section_ID`	BIGINT	NOT NULL	COMMENT '강의 정보'
);

CREATE TABLE `section` (
	`section_ID`	BIGINT	NOT NULL	COMMENT '강의 정보',
	`name`	VARCHAR((100)	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한'
);

CREATE TABLE `review` (
	`ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`rating`	FLOAT(4)	NOT NULL	COMMENT '아이디로 사용하는 이메일',
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `bookmark_teacher` (
	`bookmark_tch_ID`	BIGINT	NOT NULL,
	`add_date`	DATETIME	NULL,
	`tch_id`	BIGINT	NOT NULL	COMMENT '선생님 정보',
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `student` (
	`student_id`	BIGINT	NOT NULL,
	`name`	VARCHAR(50)	NULL	COMMENT '선생님 이름',
	`email`	VARCHAR(255)	NOT NULL	COMMENT '아이디로 사용하는 이메일',
	`mobile_number`	VARCHAR(11)	NULL,
	`join_date`	DATETIME	NULL
);

CREATE TABLE `bookmark_course` (
	`ID`	BIGINT	NOT NULL,
	`add_date`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `attend_course` (
	`ID`	BIGINT	NOT NULL,
	`post_date`	DATETIME	NULL,
	`complete`	TINYINT(1)	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `course_qna` (
	`course_qa_ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`lecture_id`	BIGINT	NOT NULL,
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `course_qna_comment` (
	`ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`course_qa_ID`	BIGINT	NOT NULL,
	`tch_id`	BIGINT	NOT NULL	COMMENT '선생님 정보',
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_tasks` (
	`lecture_tasks_id`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`lecture_id`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_quiz` (
	`lecture_quiz_id`	BIGINT	NOT NULL,
	`lecture_id`	BIGINT	NOT NULL,
	`quiz_title`	VARCHAR(255)	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`content`	TEXT	NULL
);

CREATE TABLE `board` (
	`board_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`student_id`	BIGINT	NOT NULL
);

CREATE TABLE `quiz_participation` (
	`quiz_participation_id`	BIGINT	NOT NULL,
	`lecture_quiz_id`	BIGINT	NOT NULL,
	`student_id`	BIGINT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`score`	INT(4)	NULL
);

CREATE TABLE `board_comment` (
	`board_comment_ID`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`board_ID`	BIGINT	NOT NULL,
	`student_id`	BIGINT	NOT NULL,
	`tch_id`	BIGINT	NOT NULL	COMMENT '선생님 정보'
);

CREATE TABLE `tasks_attached_file` (
	`tasks_attached_file_id`	BIGINT	NOT NULL,
	`original_file`	VARCHAR(255)	NULL,
	`upload_file`	VARCHAR(255)	NULL,
	`path`	TEXT	NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NULL,
	`file_extension`	VARCHAR(10)	NULL,
	`lecture_tasks_id`	BIGINT	NOT NULL
);

CREATE TABLE `lecture_instructor` (
	`lecture_instructor_id`	BIGINT	NOT NULL,
	`lecture_id`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NULL,
	`content`	TEXT	NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL
);

CREATE TABLE `tasks_submit` (
	`tasks_submit_id`	BIGINT	NOT NULL,
	`submit_date`	DATETIME	NULL,
	`student_id`	BIGINT	NOT NULL,
	`lecture_tasks_id`	BIGINT	NOT NULL
);

CREATE TABLE `tasks_submit_attached_file` (
	`tasks_submit_attached_file_id`	BIGINT	NOT NULL,
	`submit_student`	VARCHAR(50)	NULL,
	`original_file`	VARCHAR(255)	NULL,
	`upload_file`	VARCHAR(255)	NULL,
	`path`	TEXT	NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NULL,
	`file_extension`	VARCHAR(10)	NULL,
	`tasks_submit_id`	BIGINT	NOT NULL
);

CREATE TABLE `tutorials_attached_file` (
	`tutorials_attached_file_id`	BIGINT	NOT NULL,
	`lecture_instructor_id`	BIGINT	NOT NULL,
	`original_file_name`	VARCHAR(255)	NOT NULL,
	`upload_file_name`	VARCHAR(255)	NOT NULL,
	`path`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`file_size`	BIGINT	NULL,
	`file_extension`	VARCHAR(10)	NULL
);

CREATE TABLE `course_notice` (
	`course_notice_ID`	BIGINT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NULL,
	`modified_at`	DATETIME	NULL,
	`course_ID`	BIGINT	NOT NULL	COMMENT '강좌 자체에 대한',
	`teacher_id`	BIGINT	NOT NULL	COMMENT '선생님 정보'
);

ALTER TABLE `teacher` ADD CONSTRAINT `PK_TEACHER` PRIMARY KEY (
	`teacher_id`
);

ALTER TABLE `course` ADD CONSTRAINT `PK_COURSE` PRIMARY KEY (
	`course_ID`
);

ALTER TABLE `lecture` ADD CONSTRAINT `PK_LECTURE` PRIMARY KEY (
	`lecture_id`
);

ALTER TABLE `section` ADD CONSTRAINT `PK_SECTION` PRIMARY KEY (
	`section_ID`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`ID`
);

ALTER TABLE `bookmark_teacher` ADD CONSTRAINT `PK_BOOKMARK_TEACHER` PRIMARY KEY (
	`bookmark_tch_ID`
);

ALTER TABLE `student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`student_id`
);

ALTER TABLE `bookmark_course` ADD CONSTRAINT `PK_BOOKMARK_COURSE` PRIMARY KEY (
	`ID`
);

ALTER TABLE `attend_course` ADD CONSTRAINT `PK_ATTEND_COURSE` PRIMARY KEY (
	`ID`
);

ALTER TABLE `course_qna` ADD CONSTRAINT `PK_COURSE_QNA` PRIMARY KEY (
	`course_qa_ID`
);

ALTER TABLE `course_qna_comment` ADD CONSTRAINT `PK_COURSE_QNA_COMMENT` PRIMARY KEY (
	`ID`
);

ALTER TABLE `lecture_tasks` ADD CONSTRAINT `PK_LECTURE_TASKS` PRIMARY KEY (
	`lecture_tasks_id`
);

ALTER TABLE `lecture_quiz` ADD CONSTRAINT `PK_LECTURE_QUIZ` PRIMARY KEY (
	`lecture_quiz_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`board_ID`
);

ALTER TABLE `quiz_participation` ADD CONSTRAINT `PK_QUIZ_PARTICIPATION` PRIMARY KEY (
	`quiz_participation_id`
);

ALTER TABLE `board_comment` ADD CONSTRAINT `PK_BOARD_COMMENT` PRIMARY KEY (
	`board_comment_ID`
);

ALTER TABLE `tasks_attached_file` ADD CONSTRAINT `PK_TASKS_ATTACHED_FILE` PRIMARY KEY (
	`tasks_attached_file_id`
);

ALTER TABLE `lecture_instructor` ADD CONSTRAINT `PK_LECTURE_INSTRUCTOR` PRIMARY KEY (
	`lecture_instructor_id`
);

ALTER TABLE `tasks_submit` ADD CONSTRAINT `PK_TASKS_SUBMIT` PRIMARY KEY (
	`tasks_submit_id`
);

ALTER TABLE `tasks_submit_attached_file` ADD CONSTRAINT `PK_TASKS_SUBMIT_ATTACHED_FILE` PRIMARY KEY (
	`tasks_submit_attached_file_id`
);

ALTER TABLE `tutorials_attached_file` ADD CONSTRAINT `PK_TUTORIALS_ATTACHED_FILE` PRIMARY KEY (
	`tutorials_attached_file_id`
);

ALTER TABLE `course_notice` ADD CONSTRAINT `PK_COURSE_NOTICE` PRIMARY KEY (
	`course_notice_ID`
);

