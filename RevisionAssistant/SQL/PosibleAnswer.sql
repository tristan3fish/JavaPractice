DROP TABLE PosibleAnswer;
CREATE TABLE PosibleAnswer ( 
	PosibleAnswerId INT (10) NOT NULL,
	QuestionId INT (10) NOT NULL,
	PosibleAnswer VARCHAR (100) NOT NULL,
	PRIMARY KEY (PosibleAnswerId),
    FOREIGN KEY (QuestionId)
        REFERENCES Question(QuestionId)
        ON DELETE CASCADE
);
Show Columns from PosibleAnswer;