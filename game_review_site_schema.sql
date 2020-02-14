-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for case_study
CREATE DATABASE IF NOT EXISTS `case_study` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `case_study`;

-- Dumping structure for table case_study.game
CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `aggregate_score` double DEFAULT NULL,
  `publisher` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PUBLISH_P_ID` (`publisher`),
  CONSTRAINT `FK_PUBLISH_P_ID` FOREIGN KEY (`publisher`) REFERENCES `publishing_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.game: ~62 rows (approximately)
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`id`, `name`, `cover`, `date`, `description`, `aggregate_score`, `publisher`) VALUES
	(1, 'Super Mario Odyssey', 'images/mario_odyssey.jpg', '2017-10-27', 'New Evolution of Mario Sandbox-Style Gameplay. Mario embarks on a new journey through unknown worlds, running and jumping through huge 3D worlds in the first sandbox-style Mario game since Super Mario 64 and Super Mario Sunshine. Set sail between expansive worlds aboard an airship, and perform all-new actions, such as throwing Mario\'s cap.', NULL, 1),
	(2, 'Zelda: Breath of the Wild', 'images/zelda_botw.jpg', '2017-03-03', 'Forget everything you know about The Legend of Zelda games. Step into a world of discovery, exploration and adventure in The Legend of Zelda: Breath of the Wild, a boundary-breaking new game in the acclaimed series. Travel across fields, through forests and to mountain peaks as you discover what has become of the ruined kingdom of Hyrule in this open-air adventure.', NULL, 1),
	(3, 'Super Smash Ultimate', 'images/smash_ultimate.jpg', '2018-12-07', 'Inklings from the Splatoon series, as well as returning Smash characters like Mario and Link will be making appearances in this classic Nintendo franchise\'s Switch debut. Faster combat, new items, new attacks, new defensive options, and more will keep the battle raging whether you’re at home or on the go.', NULL, 1),
	(4, 'Fallout 4', 'images/fallout4.jpg', '2015-11-10', 'As the sole survivor of Vault 111, you enter a world destroyed by nuclear war. Every second is a fight for survival, and every choice is yours. Only you can rebuild and determine the fate of the Wasteland. Welcome home.', NULL, 3),
	(5, 'Wolfenstein II: The New Colossus', 'images/wolfenstein2.jpg', '2017-10-27', 'Wolfenstein II: The New Colossus is the highly anticipated sequel to the critically acclaimed, Wolfenstein: The New Order developed by the award-winning studio MachineGames. An exhilarating adventure brought to life by the industry-leading id Tech 6, Wolfenstein II sends players to Nazi-controlled America on a mission to recruit the boldest resistance leaders left.', NULL, 3),
	(6, 'Dishonored 2', 'images/dishonored2.jpg', '2016-11-10', 'Dishonored 2 takes your protagonist, Corvo Attano or Emily Kaldwin, to the coastal city of Karnaca where the choices you make will have significant impact on the world.', NULL, 3),
	(7, 'DOOM', 'images/doom.jpg', '2016-05-13', 'There is no taking cover or stopping to regenerate health in campaign mode as you beat back Hell’s raging demon hordes. Combine your arsenal of futuristic and iconic guns, upgrades, movement and an advanced melee system to knock-down, slash, stomp, crush, and blow apart demons in creative and violent ways.', NULL, 3),
	(8, 'Tales from the Borderlands', 'images/tales_borderlands.jpg', '2015-10-20', 'Like all good tales, there’s more than one side to a story. Especially one about a Vault key, the Hyperion Corporation, bandits, loot, gangsters, Vault Hunters, secret Atlas tech, explosions, getaways, extortion, betrayal, and mayhem. Set after the events seen in Borderlands 2, Tales from the Borderlands is about Rhys, a Hyperion company man looking to become the next Handsome Jack, and it’s also about Fiona, a Pandoran con artist out to score the biggest of all swindles.', NULL, 4),
	(9, 'Forza Horizon 4', 'images/forza4.jpg', '2018-09-28', 'For the first time in the racing and driving genre, experience dynamic seasons in a shared open-world. Explore beautiful scenery, collect over 450 cars, and become a Horizon Superstar in historic Britain.', NULL, 6),
	(10, 'Forza Horizon 3', 'images/forza3.jpg', '2016-09-23', 'You are now in charge of the Horizon Festival. Customize everything, hire and fire your friends, and explore Australia in over 350 of the world’s greatest cars. Make your Horizon the ultimate celebration of cars, music, and freedom of the open road. How you get there is up to you. With the new Horizon Blueprint feature, you have the power to create and instantly share your custom gameplay.', NULL, 6),
	(11, 'God of War', 'images/gow.jpg', '2018-08-20', 'His vengeance against the gods of Olympus far behind him, Kratos now lives as a man in the lands of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same. As mentor and protector to a son determined to earn his respect, Kratos is faced with an unexpected opportunity to master the rage that has long defined him.', NULL, 7),
	(12, 'Astro Bot: Rescue Mission', 'images/astro_bot.jpg', '2018-10-02', 'Astro Bot Rescue Mission is a platformer, developed exclusively for use with PS VR. Take control of Astro the captain Bot and go on an epic VR rescue mission to save your fellow Bots who are dispersed all over space.', NULL, 7),
	(13, 'Tetris Effect', 'images/tetris_effect.jpg', '2018-11-09', 'From deep beneath the ocean to the furthest reaches of outer space, Tetris Effect’s 30-plus stages are more than just backdrops; together with music, characters, and animations tailor-made for each level and triggered by your actions, they’re all meant to make you feel something — to convey a mood, or even provoke an emotional response.', NULL, 7),
	(14, 'Horizon Zero Dawn', 'images/hzd.jpg', '2017-02-28', 'Horizon Zero Dawn is a PS4-exclusive action role playing game developed by Guerrilla Games, creators of the Killzone franchise. As Horizon Zero Dawn’s main protagonist Aloy, a skilled hunter, explore a vibrant and lush world inhabited by mysterious mechanized creatures. Embark on an emotional journey to unravel mysteries of tribal societies, ancient artifacts and advanced technologies that will determine the fate of this planet, and of life itself.', NULL, 12),
	(15, 'What Remains of Edith Finch', 'images/edith_finch.jpg', '2017-04-25', 'The game is a collection of short stories. Each of those stories focuses on the death of a different Finch family member and each is meant to look and feel different from the others, the way no two people in any family are alike.', NULL, 7),
	(16, 'Nex Machina: Death Machine', 'images/nex_machina.jpg', '2017-06-20', 'From the collaboration between Housemarque (Resogun, Alienation, Matterfall), and Robotron and Smash TV legendary creator Eugene Jarvis comes Nex Machina, an explosive arcade experience created with competition in mind. Can you survive the mechanical onslaught of hundreds of evil robots trying to obliterate any threat?', NULL, 7),
	(17, 'Nioh', 'images/nioh.jpg', '2017-02-07', 'Take up your sword and travel to Japans blood-bathed Sengoku period an era ravaged by warring states and dark, malevolent forces and cut a violent path through the land as the masterless samurai, William. Cross blades in brutal hand-to-hand combat, wielding swords, axes, spears and even war hammers against foes both human and demon.', NULL, 20),
	(18, 'Marvel\'s Spider-Man', 'images/spider_man.jpg', '2018-09-07', 'This isn\'t the Spider-Man you\'ve known before, or seen in a movie. This is an experienced Peter Parker who is more masterful in fighting major crimes in New York City. At the same time he is struggling to balance his tumultuous personal life and career while the fate of nine million New Yorkers rests upon his shoulders.', NULL, 7),
	(19, 'MLB The Show 19', 'images/mlb19.jpg', '2019-03-26', 'MLB® The Show 19 brings you the best of baseball. Experience the ultimate duel: the 1v1 battle between hitter and pitcher to see who reigns supreme. Whether it be home runs, quick experiences, playing as legends, a full RPG experience or stiff Player vs Player competition; MLBTS 19 provides the perfect combination of authentic baseball experience mixed with video game fun.', NULL, 7),
	(20, 'MLB The Show 17', 'images/mlb17.jpg', '2017-03-28', 'With expanded missions, exclusive rewards, and all new live content', NULL, 7),
	(21, 'Wipeout: Omega Collection', 'images/wipeout_omega.jpg', '2017-06-06', 'A name synonymous with PlayStation, Wipeout is the rapid combat racer that defies gravity and defines generations. Known for its blistering speed, iconic music and pure multiplayer mayhem, Wipeout has starred on every PlayStation format since 1995 and is now set to rip through the air on PlayStation4 and PlayStation4 Pro.', NULL, 7),
	(22, 'Moss', 'images/moss.jpg', '2018-02-27', 'Meet Quill, a young mouse with dreams of greatness beyond the confines of her quiet settlement. One day while exploring the woods, she finds a mysterious stone and an ancient magic is awakened. Dramatic events quickly unfold as a distant evil extends its reach. With her uncle now in grave danger, Quill must embark on an epic journey—and she needs you there by her side.', NULL, 7),
	(23, 'Uncharted: The Lost Legacy', 'images/uncharted_legacy.jpg', '2017-08-22', 'The first standalone adventure in Uncharted franchise history led by Chloe Frazer. In order to recover a fabled ancient Indian artefact and keep it out of the hands of a ruthless war profiteer, Chloe Frazer must enlist the aid of renowned mercenary Nadine Ross (from Uncharted 4: A Thief\'s End).', NULL, 12),
	(24, 'The Last Guardian', 'images/last_guardian.jpg', '2016-12-06', 'It’s an action adventure title. It’s a story about a young boy who has been kidnapped or captured under strange circumstances. It’s about an encounter between that boy and the mysterious beast Trico amidst ancient ruins, and a story about their journey together in the hope of escaping their mysterious predicament.', NULL, 12),
	(25, 'MLB The Show 18', 'images/mlb18.jpg', '2018-03-27', 'Your team. Your rivals. Your buddies. Your hometown. No matter why you play or why you love baseball, MLB The Show 18 is for a fan like you. The Show 18 delivers baseball just the way you want it, from fielding a roster of past Legends and current Superstars in Diamond Dynasty1,2, to crushing homers with friends in Retro Mode games to meaningful RPG progression in Road to The Show®.', NULL, 7),
	(26, 'Blood & Truth', 'images/blood_truth.jpg', '2019-05-28', 'Blood & Truth takes place in modern day London against the city\'s backdrop of glamour and grit, making it the perfect location for a criminal underworld to inhabit. The capabilities of PS VR puts you into the shoes of an action hero in a way you won\'t have experienced before. From the moment you slip on the headset, you become Ryan Marks, an elite Special Forces soldier who is on a dangerous mission to save his family from a ruthless criminal overlord.', NULL, 7),
	(27, 'Gravity Rush 2', 'images/gravity_rush2.jpg', '2017-01-20', 'Prepare to fall through the skies as gravity kitten Kat masters a suite of new gravity-defying abilities and chases the mystery of her origin across a huge new open world.', NULL, 12),
	(28, 'Firewall Zero Hour', 'images/firewall_zero.jpg', '2018-08-28', 'Choose from one of 12 contractors hired by anonymous contract handlers and work as a team to either protect or obtain valuable data, housed on a laptop and located in dangerous locations around the globe.', NULL, 7),
	(29, 'Locoroco', 'images/locoroco.jpg', '2017-05-05', 'The peaceful world of the LocoRoco are under attack by the not-so-nice Moja Corps! These evil outer space creatures have come to take the LocoRoco from their land of blowing flowers, lively creatures, and pastel scenery. You must move the LocoRoco through more than 40 levels of slippery slopes, teetering platforms, and maze-like passages.', NULL, 7),
	(30, 'Detroit: Become Human', 'images/detroit_human.jpg', '2018-05-25', 'Inspired by the short called “Kara”, Detroit is a neo-noir thriller set in the near-future city of Detroit. Androids, who look exactly like human beings, have replaced humans in most tasks: they are workers, babysitters, gardeners, nurses, teachers, clerks. The story of Detroit starts with an unexplained incident that begins to affect the Androids.', NULL, 12),
	(31, 'The Persistence', 'images/persistence.jpg', '2018-07-24', 'Caught in the inexorable pull of a black hole, and with the crew mutated into horrific and murderous aberrations, it’s down to you, a clone of security officer Zimri Eder, to save the ship and make the jump back to earth.', NULL, 7),
	(32, 'Rigs: Mechanized Combat League', 'images/rigs_combat.jpg', '2016-10-13', 'Launching exclusively for PlayStation VR, RIGS throws you into explosive battle arenas where mechanised combat and futuristic sports collide head-on. Immerse yourself into a single player experience that will push your skills to the limit and sharpen your team tactics. Unlock new and more powerful RIGS to then take online against the world.', NULL, 12),
	(33, 'Nier: Automata', 'images/nier_automata.jpg', '2017-03-07', 'NieR Producer Yosuke Saito, director Taro Yoko and composer Keiichi Okabe return, teaming up with character designer Akihiko Yoshida and PlatinumGames to present the next entry in the saga – NieR: Automata.', NULL, 8),
	(34, 'Downwell', 'images/downwell.jpg', '2015-10-15', 'Downwell is a curious game about a young boy venturing down a well in search of untold treasures with only his Gunboots to protect him. Make your way further and further down into the darkness filled with nasty creatures and mysterious secrets to collect the spectacular red gems scattered about the rocks.', NULL, 10),
	(35, 'Reigns', 'images/reigns.jpg', '2016-08-11', 'Sit on the throne as a benevolent (or malevolent) medieval monarch of the modern age and swipe your royal fingers either left or right to impose your will upon the kingdom. Survive the seemingly never-ending gauntlet of requests from your advisors, peasants, allies, and enemies while maintaining balance between the influential factions of your kingdom.', NULL, 10),
	(36, 'Katana ZERO', 'images/katana_zero.jpg', '2019-04-17', 'Katana ZERO is a stylish neo-noir, action-platformer featuring breakneck action and instant-death combat. Slash, dash, and manipulate time to unravel your past in a beautifully brutal acrobatic display.', NULL, 10),
	(37, 'Enter the Gungeon', 'images/gungeon.jpg', '2016-04-05', 'Enter the Gungeon is a bullet hell dungeon crawler following a band of misfits seeking to shoot, loot, dodge roll and table-flip their way to personal absolution by reaching the legendary Gungeon’s ultimate treasure: the gun that can kill the past.', NULL, 10),
	(38, 'The Messenger', 'images/messenger.jpg', '2018-08-30', 'As a demon army besieges his village, a young ninja ventures through a cursed world, to deliver a scroll paramount to his clan’s survival. What begins as a classic action platformer soon unravels into an expansive time-traveling adventure full of thrills, surprises, and humor.', NULL, 10),
	(39, 'GORN', 'images/gorn.jpg', '2019-07-18', 'GORN is a ludicrously violent VR gladiator simulator, made by Free Lives, the developers of Broforce and Genital Jousting.', NULL, 10),
	(40, 'Ape Out', 'images/ape_out.jpg', '2019-02-28', 'Ape Out is a wildly intense and colorfully stylized smash ‘em up about primal escape, rhythmic violence, and frenetic jazz.', NULL, 10),
	(41, 'GRIS', 'images/gris.jpg', '2018-12-13', 'Gris is a hopeful young girl lost in her own world, dealing with a painful experience in her life. Her journey through sorrow is manifested in her dress, which grants new abilities to better navigate her faded reality.', NULL, 10),
	(42, 'Red Dead Redemption 2', 'images/red_dead2.jpg', '2018-10-26', 'Developed by the creators of Grand Theft Auto V and Red Dead Redemption, Red Dead Redemption 2 is an epic tale of life in America’s unforgiving heartland. The game’s vast and atmospheric world also provides the foundation for a brand new online multiplayer experience. America, 1899. The end of the Wild West era has begun.', NULL, 11),
	(43, 'Uncharted 4: A Thief\'s End', 'images/uncharted4.jpg', '2016-05-10', 'Set 3 years after the events of Uncharted 3, Nathan Drake has apparently left the world of fortune hunting behind. However, it doesn’t take long for adventure to come calling when Drake’s brother, Sam, re-emerges asking for his help to save his own life and offering an adventure Drake cannot resist.', NULL, 12),
	(44, 'Bloodborne', 'images/bloodborne.jpg', '2015-03-24', 'Bloodborne is an action RPG in which you hunt for answers in the ancient city of Yharnam, now cursed with a strange endemic illness spreading through the streets like a disease. Peril, death and madness infest this dark world, and you\'re tasked with uncovering its darkest secrets which will be necessary for you to survive.', NULL, 12),
	(45, 'Sekiro: Shadows Die Twice', 'images/sekiro_shadow.jpg', '2019-03-22', 'Your death won’t come easily. Enter the world of late 1500s Sengoku Japan; a brutal, bloody period of constant life-and-death conflict. As tensions rise, a compelling new story unfolds amongst the chaos. Introducing Sekiro: Shadows Die Twice, a dark and twisted new gameplay experience developed by the renowned team at FromSoftware and published by Activision.', NULL, 13),
	(46, 'A Plague Tale: Innocence', 'images/plague_tale.jpg', '2019-05-14', 'A Plague Tale: Innocence offers an adventure supported by an original scenario, with gameplay that blends action, adventure and stealth phases. Follow our protagonists Amicia and her little brother Hugo, both orphans and on the run from the terrifying Inquisition. Our young heroes will also need to survive against an even greater danger: supernatural swarms of rats that appeared with the great plague infecting across cities and countryside.', NULL, 14),
	(47, 'GreedFall', 'images/greedfall.jpg', '2019-09-10', 'Explore uncharted new lands as you set foot on a remote island seeping with magic, and filled with riches, lost secrets, and fantastic creatures. Forge this new world\'s destiny, as you befriend or betray companions and entire factions. With diplomacy, deception and force, become part of a living, evolving world - influence its course and shape your story.', NULL, 14),
	(48, 'Insurgency: Sandstorm', 'images/insurgency_sandstorm.jpg', '2018-12-12', 'Insurgency: Sandstorm is a team-based, tactical FPS based on lethal close quarters combat and objective-oriented multiplayer gameplay. Experience the intensity of modern combat where skill is rewarded, and teamwork wins the fight.', NULL, 14),
	(49, 'The Surge 2', 'images/surge2.jpg', '2019-09-24', 'On the way to Jericho City, your plane is shot down by a mysterious storm and crash-lands in the outskirts. You wake up weeks later in a derelict detention facility inside the city. Armor-clad soldiers enforce Martial Law, robots are on a rampage, and a dark, expanding nanostorm looms over the cityscape...', NULL, 14),
	(50, 'Battlefleet Gothic: Armada 2', 'images/battlefleet_gothic2.jpg', '2019-01-24', 'Battlefleet Gothic: Armada 2 is the new real-time strategy game adapted from Games Workshop’s famous tabletop game that portrays the epic space battles of the Warhammer 40,000 universe.', NULL, 14),
	(51, 'Farming Simulator 19', 'images/farming_simulator19.jpg', '2018-11-20', 'The multimillion-selling franchise takes a giant leap forward for 2018 -- the ultimate farming simulation returns this year with a complete overhaul of the graphics engine, offering the most striking and immersive visuals and effects, along with the deepest and most complete farming experience ever!', NULL, 14),
	(52, 'Battlefleet Gothic: Armada', 'images/battlefleet_gothic.jpg', '2016-04-21', 'Developed on Unreal Engine 4, Battlefleet Gothic: Armada is an RTS in which the player takes command of one of these battlefleets composed of the most powerful spaceships from the Imperial, Chaos, Eldar and Ork forces, in a no-quarter-given struggle for the control of the Gothic sector of space.', NULL, 14),
	(53, 'Spintires: MudRunner', 'images/spintires_mudrunner.jpg', '2017-10-30', 'Spintires: MudRunner is the ultimate version of the million-seller indie hit Spintires. Like Spintires before it, Spintires: MudRunner puts players in the driver seat and dares them to take charge of incredible all-terrain vehicles, venturing across extreme Siberian landscapes with only a map and compass as guides!', NULL, 14),
	(54, 'Masters of Anima', 'images/masters_anime.jpg', '2018-04-10', 'Dive into an original adventure and defy the forces of evil in strategic, action-packed battles. Summon and control large armies of up to 100 Guardians thanks to intuitive and innovative gameplay and make quick tactical decisions to prevail.', NULL, 14),
	(55, 'Dark Souls III', 'images/dark_souls3.jpg', '2016-04-11', 'Developed by Japanese developer FromSoftware, DARK SOULS III is the latest chapter in the DARK SOULS series with its trademark sword and sorcery combat and rewarding action RPG gameplay. Players travel across a wide variety of locations in an interconnected world of unrelenting challenge and deep RPG gameplay as they search for a way to survive the coming apocalypse.', NULL, 15),
	(56, 'Dragon Ball FighterZ', 'images/dragon_fighterz.jpg', '2018-01-26', 'After the success of the Xenoverse series, its time to introduce a new classic 2D DRAGON BALL fighting game for this generations consoles. DRAGON BALL FighterZ is born from what makes the DRAGON BALL series so loved and famous: endless spectacular fights with its allpowerful fighters.', NULL, 15),
	(57, 'Project CARS 2', 'images/project_cars2.jpg', '2017-09-22', 'Project CARS 2 is the next evolution in the award-winning racing series, featuring the most iconic cars racing under the most thrilling conditions to deliver the Ultimate Driver Journey.', NULL, 15),
	(58, 'SoulCalibur VI', 'images/soulcalibur6.jpg', '2018-10-19', 'History Hides Away More Than One Truth... SOULCALIBUR VI represents the latest entry in the premier weapons-based, head-to-head fighting series and continues the epic struggle of warriors searching for the legendary Soul Swords. Taking place in the 16th century, revisit the events of the original SOULCALIBUR to uncover hidden truths.', NULL, 15),
	(59, 'Project CARS', 'images/project_cars.jpg', '2015-05-06', 'Create a driver, pick from a variety of motorsports, and shift into high gear to chase a number of Historic Goals and ultimate recognition in the Hall Of Fame. Then test your skills online either in competitive fully-loaded race weekends, leaderboard-based time challenges, or continually-updated community events.', NULL, 15),
	(60, 'Pillars of Eternity II: Deadfire', 'images/pillars_eternity2.jpg', '2018-05-08', 'Pursue a rogue god over land and sea in the sequel to the multi-award-winning RPG Pillars of eternity. Captain your ship on a dangerous voyage of discovery across the vast unexplored archipelago region of the dead Fire. Bend the world to your will, as you explore the depths of Infinite possibilities, including detailed character customization, total freedom of exploration, and more meaningful choices at every turn.', NULL, 16),
	(61, 'The Outer Worlds', 'images/outer_worlds.jpg', '2019-10-25', 'The Outer Worlds is a new single-player first-person sci-fi RPG from Obsidian Entertainment and Private Division. Lost in transit while on a colonist ship bound for the furthest edge of the galaxy, you awake decades later only to find yourself in the midst of a deep conspiracy threatening to destroy the Halcyon colony.', NULL, 16),
	(62, 'Pathfinder Adventures', 'images/pathfinder_adventures.jpg', '2016-04-27', 'N/A', NULL, 16);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- Dumping structure for table case_study.game_genre
CREATE TABLE IF NOT EXISTS `game_genre` (
  `game_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  KEY `FK_GAME2_G_ID` (`game_id`),
  KEY `FK_GENRE_E_ID` (`genre_id`),
  CONSTRAINT `FK_GAME2_G_ID` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `FK_GENRE_E_ID` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.game_genre: ~110 rows (approximately)
DELETE FROM `game_genre`;
/*!40000 ALTER TABLE `game_genre` DISABLE KEYS */;
INSERT INTO `game_genre` (`game_id`, `genre_id`) VALUES
	(1, 1),
	(1, 7),
	(2, 1),
	(2, 2),
	(3, 1),
	(3, 3),
	(4, 11),
	(5, 1),
	(5, 4),
	(6, 1),
	(6, 2),
	(7, 1),
	(7, 4),
	(7, 15),
	(8, 2),
	(9, 9),
	(9, 12),
	(10, 9),
	(10, 12),
	(11, 1),
	(11, 2),
	(12, 1),
	(12, 2),
	(13, 8),
	(14, 11),
	(14, 1),
	(15, 2),
	(15, 4),
	(16, 1),
	(16, 4),
	(17, 11),
	(17, 1),
	(18, 1),
	(18, 2),
	(19, 13),
	(19, 12),
	(20, 13),
	(20, 12),
	(21, 9),
	(22, 1),
	(22, 2),
	(23, 1),
	(24, 1),
	(24, 2),
	(25, 13),
	(25, 12),
	(26, 1),
	(27, 1),
	(27, 7),
	(28, 1),
	(28, 4),
	(28, 14),
	(29, 1),
	(29, 7),
	(30, 1),
	(30, 2),
	(30, 15),
	(31, 2),
	(31, 4),
	(32, 12),
	(33, 11),
	(33, 1),
	(34, 1),
	(35, 12),
	(37, 1),
	(38, 1),
	(38, 7),
	(39, 1),
	(40, 1),
	(41, 1),
	(41, 7),
	(36, 1),
	(36, 7),
	(42, 1),
	(42, 2),
	(43, 1),
	(43, 2),
	(44, 11),
	(44, 1),
	(44, 2),
	(45, 1),
	(45, 2),
	(46, 1),
	(46, 2),
	(47, 11),
	(47, 1),
	(49, 11),
	(49, 1),
	(50, 10),
	(51, 12),
	(52, 10),
	(53, 12),
	(54, 10),
	(55, 11),
	(55, 1),
	(56, 1),
	(56, 3),
	(57, 9),
	(57, 12),
	(58, 1),
	(58, 3),
	(59, 9),
	(59, 12),
	(60, 11),
	(61, 11),
	(62, 16),
	(48, 14),
	(50, 14),
	(52, 14),
	(53, 14);
/*!40000 ALTER TABLE `game_genre` ENABLE KEYS */;

-- Dumping structure for table case_study.genre
CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.genre: ~18 rows (approximately)
DELETE FROM `genre`;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` (`id`, `name`) VALUES
	(1, 'action'),
	(2, 'adventure'),
	(3, 'fighting'),
	(4, 'fps'),
	(5, 'flying'),
	(6, 'party'),
	(7, 'platformer'),
	(8, 'puzzle'),
	(9, 'racing'),
	(10, 'rts'),
	(11, 'rpg'),
	(12, 'simulation'),
	(13, 'sports'),
	(14, 'strategy'),
	(15, 'tps'),
	(16, 'tbs'),
	(17, 'wargames'),
	(18, 'wrestling');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;

-- Dumping structure for table case_study.publishing_company
CREATE TABLE IF NOT EXISTS `publishing_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.publishing_company: ~29 rows (approximately)
DELETE FROM `publishing_company`;
/*!40000 ALTER TABLE `publishing_company` DISABLE KEYS */;
INSERT INTO `publishing_company` (`id`, `name`) VALUES
	(1, 'Nintendo'),
	(2, 'Ubisoft'),
	(3, 'Bethesda'),
	(4, 'Telltale'),
	(5, 'Electronic Arts'),
	(6, 'Microsoft'),
	(7, 'Sony'),
	(8, 'Square Enix'),
	(9, 'Sega'),
	(10, 'Devolver'),
	(11, 'Rockstar'),
	(12, 'SCEA'),
	(13, 'Activision'),
	(14, 'Focus Home'),
	(15, 'Bandai Namco'),
	(16, 'Obsidian'),
	(17, 'Warner Bros.'),
	(18, 'CAPCOM'),
	(19, 'Paradox'),
	(20, 'Koei Tecmo'),
	(21, '2K'),
	(22, 'Atlus'),
	(23, 'Quantic Dream'),
	(24, 'Maximum'),
	(25, 'From Software'),
	(26, 'Blizzard'),
	(27, 'Konami'),
	(28, 'EA Games'),
	(29, 'Frontier'),
	(30, 'Valve');
/*!40000 ALTER TABLE `publishing_company` ENABLE KEYS */;

-- Dumping structure for table case_study.review
CREATE TABLE IF NOT EXISTS `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL DEFAULT '0',
  `score` double NOT NULL DEFAULT 0,
  `game` int(11) NOT NULL DEFAULT 0,
  `author` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_GAME_G_ID` (`game`),
  KEY `FK_USER_U_ID` (`author`),
  CONSTRAINT `FK_GAME_G_ID` FOREIGN KEY (`game`) REFERENCES `game` (`id`),
  CONSTRAINT `FK_USER_U_ID` FOREIGN KEY (`author`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.review: ~0 rows (approximately)
DELETE FROM `review`;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

-- Dumping structure for table case_study.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table case_study.user: ~2 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
	(1, 'aaron', 'aaron@gmail.com', 'F@re80optal'),
	(2, 'erin', 'erin@gmail.com', 'Latp#80ruff');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
