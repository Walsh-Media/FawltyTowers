-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FawltyTowers
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FawltyTowers` ;

-- -----------------------------------------------------
-- Schema FawltyTowers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FawltyTowers` DEFAULT CHARACTER SET utf8 ;
USE `FawltyTowers` ;

-- -----------------------------------------------------
-- Table `FawltyTowers`.`RoomType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FawltyTowers`.`RoomType` ;

CREATE TABLE IF NOT EXISTS `FawltyTowers`.`RoomType` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FawltyTowers`.`Room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FawltyTowers`.`Room` ;

CREATE TABLE IF NOT EXISTS `FawltyTowers`.`Room` (
  `Id` INT NOT NULL,
  `Number` VARCHAR(45) NOT NULL,
  `RoomTypeId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Number_UNIQUE` (`Number` ASC) VISIBLE,
  INDEX `fk_Room_RoomType1_idx` (`RoomTypeId` ASC) VISIBLE,
  CONSTRAINT `fk_Room_RoomType1`
    FOREIGN KEY (`RoomTypeId`)
    REFERENCES `FawltyTowers`.`RoomType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FawltyTowers`.`Booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FawltyTowers`.`Booking` ;

CREATE TABLE IF NOT EXISTS `FawltyTowers`.`Booking` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Telephone` VARCHAR(45) NULL,
  `CheckInDate` DATETIME NOT NULL,
  `CheckOutDate` DATETIME NULL,
  `RoomId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Booking_Room_idx` (`RoomId` ASC) VISIBLE,
  CONSTRAINT `fk_Booking_Room`
    FOREIGN KEY (`RoomId`)
    REFERENCES `FawltyTowers`.`Room` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `FawltyTowers`.`RoomType`
-- -----------------------------------------------------
START TRANSACTION;
USE `FawltyTowers`;
INSERT INTO `FawltyTowers`.`RoomType` (`Id`, `Name`) VALUES (1, 'Single');
INSERT INTO `FawltyTowers`.`RoomType` (`Id`, `Name`) VALUES (2, 'Double');

COMMIT;


-- -----------------------------------------------------
-- Data for table `FawltyTowers`.`Room`
-- -----------------------------------------------------
START TRANSACTION;
USE `FawltyTowers`;
INSERT INTO `FawltyTowers`.`Room` (`Id`, `Number`, `RoomTypeId`) VALUES (1, '1', 1);
INSERT INTO `FawltyTowers`.`Room` (`Id`, `Number`, `RoomTypeId`) VALUES (2, '2', 1);
INSERT INTO `FawltyTowers`.`Room` (`Id`, `Number`, `RoomTypeId`) VALUES (3, '3', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `FawltyTowers`.`Booking`
-- -----------------------------------------------------
START TRANSACTION;
USE `FawltyTowers`;
INSERT INTO `FawltyTowers`.`Booking` (`Id`, `FirstName`, `LastName`, `Telephone`, `CheckInDate`, `CheckOutDate`, `RoomId`) VALUES (1, 'John', 'Doe', '01 123 4567', '2020-11-01', '2020-11-03', 1);

COMMIT;

