package com.example.salvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.omg.CORBA.StringHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
    public CommandLineRunner initData(PlayersRepository playersRepository,
                                      GameRepository gameRepository,
                                      GamePlayerRepository gameplayerRepository,
                                      ShipRepository shipRepository,
                                      SalvoRepository salvoRepository){
	    return(args) -> {







	        Game game1 = new Game();
	        Game game2 = new Game();
            Game game3 = new Game();
            Game game4 = new Game();
            Game game5 = new Game();

            Player player1 = new Player("Jack","john");
            Player player2 = new Player("Kim","Kardashi");
            Player player3 = new Player("Mike","Neumann");
            Player player4 = new Player("David","Smith");
            Player player5 = new Player("john","Sonntag");

	        playersRepository.save(player1);
	        playersRepository.save(player2);
	        playersRepository.save(player3);
	        playersRepository.save(player4);
	        playersRepository.save(player5);

	        gameRepository.save(game1);
	        gameRepository.save(game2);
	        gameRepository.save(game3);
            gameRepository.save(game4);
            gameRepository.save(game5);

            GamePlayer gp1 = new GamePlayer(game1,player1);
            GamePlayer gp2 = new GamePlayer(game1,player2);
            GamePlayer gp3 = new GamePlayer(game3,player4);
            GamePlayer gp4 = new GamePlayer(game3,player5);
            GamePlayer gp5 = new GamePlayer(game4,player3);
            GamePlayer gp6 = new GamePlayer(game5,player1);
            GamePlayer gp7 = new GamePlayer(game2,player3);
            GamePlayer gp8 = new GamePlayer(game2,player5);

            gameplayerRepository.save(gp1);
            gameplayerRepository.save(gp2);
            gameplayerRepository.save(gp3);
            gameplayerRepository.save(gp4);
            gameplayerRepository.save(gp5);
            gameplayerRepository.save(gp6);
            gameplayerRepository.save(gp7);
            gameplayerRepository.save(gp8);

            List<String> loc1 = Arrays.asList("H1", "H2", "H3");
            List<String> loc2 = Arrays.asList("A4", "B4","C4");
            List<String> loc3 = Arrays.asList("D1", "D2");
            List<String> loc4 = Arrays.asList("E5", "E4");
            List<String> loc5 = Arrays.asList("I8", "I7");
            List<String> loc6 = Arrays.asList("B8", "B7");

            Ship ship1 = new Ship("destroy",loc1);
            Ship ship2 = new Ship("patrol",loc2);
            Ship ship4 = new Ship("cruz",loc4);
            Ship ship5 = new Ship("destroy",loc1);
            Ship ship6 = new Ship("bomb",loc3);
            Ship ship7 = new Ship("submarine",loc5);
            Ship ship12 = new Ship("Battleship",loc6);
            Ship ship13 = new Ship("patrol",loc2);
            Ship ship14 = new Ship("submarine",loc5);
            Ship ship15 = new Ship("patrol",loc2);
            Ship ship8 = new Ship("Battleship",loc2);
            Ship ship9 = new Ship("patrol",loc2);
            Ship ship10 = new Ship("cruz",loc4);
            Ship ship16 = new Ship("Battleship",loc6);



            gp1.addships(ship1);
            gp1.addships(ship2);
            gp2.addships(ship5);
            gp3.addships(ship4);
            gp4.addships(ship6);
            gp4.addships(ship7);
            gp5.addships(ship6);
            gp5.addships(ship12);
            gp3.addships(ship14);
            gp3.addships(ship15);
            gp4.addships(ship10);
            gp1.addships(ship16);
            gp2.addships(ship9);
            gp2.addships(ship8);
            gp5.addships(ship13);

            shipRepository.save(ship1);
            shipRepository.save(ship2);
            shipRepository.save(ship13);
            shipRepository.save(ship4);
            shipRepository.save(ship5);
            shipRepository.save(ship6);
            shipRepository.save(ship7);
            shipRepository.save(ship8);
            shipRepository.save(ship9);
            shipRepository.save(ship10);
            shipRepository.save(ship12);
            shipRepository.save(ship14);
            shipRepository.save(ship15);
            shipRepository.save(ship16);


            List<String> selvolocation1 = Arrays.asList("B4","D4","C5");
            List<String> selvolocation2 = Arrays.asList("B1","B4");
            List<String> selvolocation3 = Arrays.asList("G1","I7");
            List<String> selvolocation4 = Arrays.asList("C5","D4");
            List<String> selvolocation5 = Arrays.asList("A9","B10");
            List<String> selvolocation6 = Arrays.asList("E6","H1","H5");
            List<String> selvolocation7 = Arrays.asList("F1","H4","H5");
            List<String> selvolocation8 = Arrays.asList("F7","C8","B5");
            List<String> selvolocation9 = Arrays.asList("C9","E4");
            List<String> selvolocation10 = Arrays.asList("B7","E5");
            List<String> selvolocation11 = Arrays.asList("B7","B8");

            Salvo salvo1 = new Salvo(1.0,selvolocation1,gp1);
            Salvo salvo2 = new Salvo(2.0,selvolocation2,gp2);
            Salvo salvo3 = new Salvo(3.0,selvolocation3,gp3);
            Salvo salvo4 = new Salvo(4.0,selvolocation4,gp4);
            Salvo salvo5 = new Salvo(5.0,selvolocation5,gp5);
            Salvo salvo6 = new Salvo(2.0,selvolocation6,gp1);
            Salvo salvo7 = new Salvo(3.0,selvolocation7,gp2);
            Salvo salvo8 = new Salvo(8.0,selvolocation8,gp3);
            Salvo salvo9 = new Salvo(9.0,selvolocation9,gp4);
            Salvo salvo10 = new Salvo(10.0,selvolocation10,gp5);
            Salvo salvo11 = new Salvo(1.0,selvolocation11,gp5);

            salvoRepository.save(salvo1);
            salvoRepository.save(salvo2);
            salvoRepository.save(salvo3);
            salvoRepository.save(salvo4);
            salvoRepository.save(salvo5);
            salvoRepository.save(salvo6);
            salvoRepository.save(salvo7);
            salvoRepository.save(salvo8);
            salvoRepository.save(salvo9);
            salvoRepository.save(salvo10);

        };


    }
}
