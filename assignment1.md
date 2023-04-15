# Assignment 1 - Part A (Worth 5%)

## Scope

Assignment 1 covers everything from week 1 to week 4 of lectures and week 1 to 5 of practical classes. You may use recursion but it's not required.

## Twitter

You don't need to have used Twitter previously in order to do this assignment. Although a basic understanding will be helpful in understanding the structure of class files.

### Introduction

This assignment deals with modelling a simple implementation of the Twitter system. 

### User
The User class represents a single user in the system. Users have the following attributes:
- handle: a unique username
- bio: a shot description for the user
- followers: a list of names who are following the user
- following: a list of names who the user is following
- verified: whether the User is a verified account or not

### Reply
The Reply class represents a message or reply to another user 
- from: the User who made this reply
- to: a list of users to which this reply is addressed to
- message: the actual content of the reply
- views: how many views this reply has recieved

### Tweet
The Tweet class represents a "post" or an initial post in a "thread"
- poster: the user who made this Tweet
- message: the actual content of the Tweet
- replies: the different replies that have been made in this Tweet
- views: how many views this Tweet has recieved

### Tweet
The Timeline class represents a curated list of Tweets (or recommendations) for a specific user.
- owner: the owner of this Timeline i.e. the User who these Tweets are being recommended to
- tweets: the actual Tweets being recommended

### Twitter
The Twitter class represents a collection of different timelines and users.
- timelines: the different recommendations to various users.
- users: all the users on the platform

## Stages

### Stages 1, 2

Stages 1 and 2 are based on week 3 lecture with one or two components from the week 4 lecture.

### Stages 3, 4, 5

Stages 3 to 5 are based on weeks 3 and 4 lectures.

## Use of built-in ArrayList class is prohibited

Make sure you do not create or use any ArrayList objects in the assignment. Standard rules apply to this assignment.

## Grading

- Total marks for tests: 80
	- Stage 1: each of the 2 tests worth 5 marks (10 marks)
	- Stage 2: each of the 4 tests worth 5 marks (20 marks)
	- Stage 3: each of the 7 tests worth 4 marks (28 marks)
	- Stage 4: each of the 7 tests worth 2 marks (14 marks)
	- Stage 5: each of the 4 tests worth 2 marks (8 marks)
- Code style (based on test marks): Up to 20 
	- For example, if you get 60/80 (75%) in your tests, you qualify for 75% of the marks for coding style (15/20). Coding style guide provided
	- Marking Guide for code style
		- Commenting (10 marks)
			- 10 if appropriate level of commenting at all places
			- 7 if appropriate level of commenting at most places
			- 4 if appropriate level of commenting at some places
			- 0 if appropriate level of commenting at very few (or no) places
		- Indentation (5 marks)
			- 5 if perfect and consistently-styled indentation everywhere 
			- 3 if perfect and consistently-styled indentation at most places
			- 1 if perfect and consistently-styled indentation at some places 
			- 0 if perfect and consistently-styled indentation at very few (or no) places 
		- Variable naming (5 marks)
			- 5 if variable names indicate their purpose (or are widely-accepted names) at all places 
			- 3 if variable names indicate their purpose (or are widely-accepted names) at most places 
			- 1 if variable names indicate their purpose (or are widely-accepted names) at some places 
			- 0 if variable names indicate their purpose (or are widely-accepted names) at few (or no) places 

## Checkpoints

- Checkpoint for stages 1 - 5: 2nd April 21:00
- Checkpoint for stages 1 - 5: 9th April 21:00
- Checkpoint for stages 1 - 5: 13th April 21:00

## Submission details

Files to submit - the five .java files in stage1 to stage5 packages. Submit only the files, not the folders.

Sunday 15th April 23:55. See the unit for late submission policy.