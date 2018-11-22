BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `userTable` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`IDNumber`	TEXT NOT NULL,
	`Name`	TEXT NOT NULL,
	`Surname`	TEXT NOT NULL,
	`Email`	TEXT NOT NULL,
	`Password`	TEXT NOT NULL,
	`DedicatedHunter`	INTEGER NOT NULL,
	`DateJoined`	TEXT DEFAULT 'NotJoined'
);
INSERT INTO `userTable` VALUES (1,'9706145024082','Mark','van der Burgh','mkvdburgh@gmail.com','mark2018',0,'NotJoined');
INSERT INTO `userTable` VALUES (2,'9704165080084','Alexander','McMichael','alexMc2018@yahoo.com','alexMc123',1,'08/10/2018');
INSERT INTO `userTable` VALUES (3,'9512125207089','Tristan','Fraser','tjafraser@mweb.co.za','Tristan#roks',1,'08/10/2018');
CREATE TABLE IF NOT EXISTS `SpeciesLog` (
	`_id`	INTEGER NOT NULL,
	`birdName`	TEXT NOT NULL,
	`birdType`	TEXT NOT NULL,
	`NumBirdsSeen`	INTEGER NOT NULL,
	`NumBirdsShot`	INTEGER NOT NULL,
	`Location`	TEXT NOT NULL,
	`Date`	TEXT NOT NULL,
	`birdAge`	TEXT NOT NULL,
	PRIMARY KEY(`_id`)
);
COMMIT;
