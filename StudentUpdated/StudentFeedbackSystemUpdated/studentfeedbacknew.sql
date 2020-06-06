/*
MySQL Data Transfer
Source Host: localhost
Source Database: studentfeedback
Target Host: localhost
Target Database: studentfeedback
Date: 3/6/2018 3:46:01 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for feedback_table
-- ----------------------------
DROP TABLE IF EXISTS `feedback_table`;
CREATE TABLE `feedback_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `faculty_name` varchar(45) NOT NULL,
  `feedback_status` varchar(45) NOT NULL,
  `suggestions` varchar(200) DEFAULT NULL,
  `student_name` varchar(45) NOT NULL,
  `student_id` bigint(20) unsigned NOT NULL,
  `faculty_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for question_table
-- ----------------------------
DROP TABLE IF EXISTS `question_table`;
CREATE TABLE `question_table` (
  `q_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `question` varchar(45) NOT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student_table
-- ----------------------------
DROP TABLE IF EXISTS `student_table`;
CREATE TABLE `student_table` (
  `student_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `student_name` varchar(45) NOT NULL,
  `student_department` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enrollment_no` varchar(45) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for subject_table
-- ----------------------------
DROP TABLE IF EXISTS `subject_table`;
CREATE TABLE `subject_table` (
  `sub_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(45) NOT NULL,
  `sub_code` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `Urid` int(11) NOT NULL AUTO_INCREMENT,
  `Urole` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Urid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `faculty_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `faculty_name` varchar(255) DEFAULT NULL,
  `faculty_department` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`faculty_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `feedback_table` VALUES ('1', 'Payal', 'Good', 'aaaaaaaa', 'Ravi', '3', '4');
INSERT INTO `feedback_table` VALUES ('2', 'Supriya', 'Good', 'Please improve your skill.', 'Pragati', '3', '47');
INSERT INTO `feedback_table` VALUES ('3', 'Palak', 'Good', 'sdsddhsdsufhsd', 'Rani', '2', '3');
INSERT INTO `feedback_table` VALUES ('4', 'Akash', 'Excellent', '', 'Rani', '2', '2');
INSERT INTO `feedback_table` VALUES ('5', 'Supriya', 'Bad', 'Not understanding.', 'Siddhi', '4', '47');
INSERT INTO `feedback_table` VALUES ('6', 'Akash', 'Average', '', 'Rani', '2', '2');
INSERT INTO `feedback_table` VALUES ('7', 'Palak', 'Good', 'Try to improve your practical knowledge', 'Rani', '2', '3');
INSERT INTO `feedback_table` VALUES ('8', 'Akash', 'Bad', 'Please improve', 'Rani', '2', '2');
INSERT INTO `feedback_table` VALUES ('9', 'Pooja', 'Excellent', 'Improvment.', 'Pankti', '6', '49');
INSERT INTO `question_table` VALUES ('1', 'Explains assignments clearly?');
INSERT INTO `question_table` VALUES ('2', 'Encourages cooperation and participation?');
INSERT INTO `question_table` VALUES ('3', 'Enforces rules fairly and consistently ?');
INSERT INTO `question_table` VALUES ('4', 'Is approachable and willing to help me ?');
INSERT INTO `question_table` VALUES ('5', 'Encourages and accepts different opinions?');
INSERT INTO `question_table` VALUES ('6', 'Encourages me to think for myself?');
INSERT INTO `question_table` VALUES ('7', 'Makes class interesting and relevant?');
INSERT INTO `question_table` VALUES ('8', 'Provides opportunities for student choice?');
INSERT INTO `question_table` VALUES ('9', 'Recognizes and acknowledges effort?');
INSERT INTO `question_table` VALUES ('10', 'Communicates with my parents?');
INSERT INTO `student_table` VALUES ('2', 'Rani', 'Civil', 'S.Y.', '36456467546', 'Pune', 'rani.marathe9@gmail.com', 'Rani@', 'Student', '4465756756');
INSERT INTO `student_table` VALUES ('3', 'Pragati', 'Computer', 'S.Y.', '1234567876', 'Mumbai', 'pragatibhandalkar94@gmail.com', 'Pragati@', 'Student', '675675655');
INSERT INTO `student_table` VALUES ('4', 'Siddhi', 'Computer', 'T.Y.', '1234567876', 'Mumbai', 'shirgaonkarsiddhi@gmail.com', 'Siddhi@', 'Student', '5746755');
INSERT INTO `student_table` VALUES ('5', 'Kavita', 'Mechanical', 'B.E ', '31313131313', 'Goa', 'kavita@123', 'Kavita@', 'Student', '765756756');
INSERT INTO `student_table` VALUES ('6', 'Pankti', 'Computer', 'F.Y.', '123456767654', 'Airoli', 'pankti@123.com', 'Pankti@', 'Student', '657575575');
INSERT INTO `student_table` VALUES ('9', 'Seema', 'civil', 'T.Y.', '1212121212', 'Mumbai', 'rani.marathe9@gmail.com', 'Seema@', 'Student', '123656454656');
INSERT INTO `student_table` VALUES ('10', 'abc', 'dhhs', 'T.Y.', '1212121212', 'sdsdds', 'sdsadasd@sesd.dds', 'abc@', 'Student', '123656454656');
INSERT INTO `student_table` VALUES ('11', 'gfghfhg', 'hhh', 'T.Y.', '1234567876', 'hghg', 'rani.marathe9@gmail.com', 'gfghfhg@', 'Student', '54656757');
INSERT INTO `student_table` VALUES ('12', 'shdghsd', 'dshdhj', 'S.Y.', '1234567876', 'sdbshb', 'dsds@WE343.com', 'shdghsd@', 'Student', '1313113');
INSERT INTO `subject_table` VALUES ('1', 'Cyber Security', 'A001', 'T.Y.B.E sem II', 'Computer');
INSERT INTO `subject_table` VALUES ('2', 'DSP', 'A002', 'T.Y.', 'Computer');
INSERT INTO `subject_table` VALUES ('3', 'Cyber Security', 'A002', 'thirdyear', 'civil');
INSERT INTO `subject_table` VALUES ('4', 'AI', 'A003', 'S.Y.B.E', 'Computer');
INSERT INTO `subject_table` VALUES ('5', 'DSP', '200', 'S.Y.B.E', 'E&TC');
INSERT INTO `subject_table` VALUES ('6', 'DDA', '300', 'T.Y.B.E sem II', 'Computer');
INSERT INTO `userrole` VALUES ('1', 'Student');
INSERT INTO `userrole` VALUES ('2', 'Staff');
INSERT INTO `userrole` VALUES ('3', 'HOD');
INSERT INTO `usertable` VALUES ('2', 'Akash', 'Civil', 'T.Y.sem II', '345443543', 'Mumbai', 'akash@gmail.com', 'akash', 'Staff');
INSERT INTO `usertable` VALUES ('3', 'Palak', 'Civil', 'F.Y.sem I', '324343445', 'Nagpur', 'palak@gmail.com', 'palak', 'Staff');
INSERT INTO `usertable` VALUES ('4', 'Payal', 'Computer', 'S.Y.sem II', '1234567898', 'Airoli', 'payal@123', 'payal', 'Staff');
INSERT INTO `usertable` VALUES ('5', 'Asha', 'Mechanical', 'S.Y.sem III', '1233467576', 'Thane', 'asha@123', 'asha', 'Staff');
INSERT INTO `usertable` VALUES ('12', 'Kapil', 'IT', 'F.Y.sem I ', '9876786787', 'Mumbai', 'kapil@123', 'kapil', 'Staff');
INSERT INTO `usertable` VALUES ('13', 'lalita', 'Mechanical', 'S.Y.sem II', '6787659876', 'Thane', 'lalita@123', 'lalita', 'Staff');
INSERT INTO `usertable` VALUES ('14', 'Pari', 'E&TC', 'S.Y.sem III', '9874678764', 'Pune', 'pari@gmail.com', 'pari', 'Staff');
INSERT INTO `usertable` VALUES ('43', 'kiran', 'Mechanical', 'S.Y. sem II ', '9878987677', 'Thane', 'kiran@gmail.com', 'kiran', 'Staff');
INSERT INTO `usertable` VALUES ('44', 'Piya', 'Mechanical', 'S.Y. sem I ', '1234676567', 'Nagpur', 'dhhhsd', 'piya', 'Staff');
INSERT INTO `usertable` VALUES ('46', 'Ashwini', 'Computer', 'F.Y.sem I ', '1235555598', 'Airoli', 'assdhds@gmail.com', 'ashwini', 'Staff');
INSERT INTO `usertable` VALUES ('47', 'Supriya', 'Computer', 'F.Y.sem I ', '7678767876', 'Pune', 'supriya@gmail.com', '1234', 'Staff');
INSERT INTO `usertable` VALUES ('48', 'Gaurav', 'Mechanical', 'T.Y.sem III', '1212121212', 'Pune', 'rajeshwarijha43@gmail.com', 'gaurav', 'Staff');
INSERT INTO `usertable` VALUES ('49', 'Pooja', 'Computer', 'F.Y.sem I ', '1234567876', 'Mumbai', 'poojaayare29@gmail.com', 'pooja', 'Staff');
