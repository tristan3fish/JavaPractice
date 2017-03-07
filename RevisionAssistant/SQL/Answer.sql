DROP TABLE Answer;
CREATE TABLE Answer ( 
	AnswerId INT (10) NOT NULL,
	TimeCreated DATETIME NOT NULL,
	Answer INT(10) NOT NULL,
	Correct BOOLEAN NOT NULL,
	Hesitation_ms BIGINT NOT NULL,
	QuestionId INT (10) NOT NULL,
	PRIMARY KEY (AnswerId),
    FOREIGN KEY (QuestionId)
        REFERENCES Question(QuestionId)
        ON DELETE CASCADE
);
Show Columns from Answer;
