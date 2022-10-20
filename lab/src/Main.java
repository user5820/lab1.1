import java.util.Scanner;
//Разработать класс для хранения информации о футбольных командах:
//Название, город, место_в_лиге, количество_побед
//и реализовать алгоритм работы с массивом данных объектов, в котором
//требуется:
//– определить команду с самым большим количеством побед;
//– определить команды с количеством побед больше среднего;
//– упорядочить массив по убыванию мест в лиге;
//– организовать поиск по названию команды, исправление одного из полей и вывод полной информации о команде после редактирования.

class Team{
    String name;
    String city;
    int rating;
    int winstreak;
}

public class Archive {
    public static void main(String[] args){
        System.out.print("Введите количество команд: ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        Team[] comand = new Team[count];
        for (int i = 0; i < count; i++){
            comand[i] = new Team();
            System.out.println("Name");
            comand[i].name = sc.nextLine();
            System.out.println("City");
            comand[i].city = sc.nextLine();
            System.out.println("Rating");
            comand[i].rating = sc.nextInt();
            System.out.println("Win streak");
            comand[i].winstreak = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < count; i++){
            System.out.println("Name:" + comand[i].name + "; " + "City:" + comand[i].city + "; "  + "Rating:" +
                    comand[i].rating + "; " + "Win streak:" + comand[i].winstreak + ";");
        }

        //- определить команду с самым большим количеством побед;

        int highestWinStreak = 0;
        int highScore = comand[highestWinStreak].winstreak;
        for (int i = 0; i < comand.length; i++){
            if (comand[i].winstreak > highScore){
                highestWinStreak = i;
                highScore = comand[highestWinStreak].winstreak;
            }
        }
        System.out.println("\nTeam with highest win streak");
        System.out.println("Name:" + comand[highestWinStreak].name + "; " + "City:" + comand[highestWinStreak].city + "; "  + "Rating:" +
                comand[highestWinStreak].rating + "; " + "Win streak:" + comand[highestWinStreak].winstreak + ";" );

        //– определить команды с количеством побед больше среднего;

        double middleStreak = 0;
        for (int i = 0; i < comand.length - 1; i++){
            middleStreak = middleStreak + comand[i].winstreak;
        }
        System.out.println("\nMiddle Streak = " + middleStreak/count);
        System.out.println("\nTeams with win streak higher than middle streak");
        for (int i = 0; i < count; i++){
            if (comand[i].winstreak > middleStreak/count){
                System.out.println("Name:" + comand[i].name + "; " + "City:" + comand[i].city + "; "  + "Rating:" +
                        comand[i].rating + "; " + "Win streak:" + comand[i].winstreak + ";");
            }
        }

        //– упорядочить массив по убыванию мест в лиге;

        for (int i = 0; i < comand.length - 1; i++){
            for (int j = 0; j < comand.length - 1 - i; j++){
                if (comand[j].rating > comand[j+1].rating){
                    Team rab = comand[j]; // rab - рабочая переменная для перестановки
                    comand[j] = comand[j + 1];
                    comand[j + 1] = rab;
                }
            }
        }
        System.out.println("\nSorted by Rating");
        for (int i = 0; i < comand.length; i++){
            System.out.println("Name:" + comand[i].name + "; " + "City:" + comand[i].city + "; "  + "Rating:" +
                    comand[i].rating + "; " + "Win streak:" + comand[i].winstreak + ";");
        }

        //– организовать поиск по названию команды, исправление одного из полей и вывод полной информации о команде после редактирования.

        int searchIndex = -1;
        System.out.println("\nEnter name of the team: ");
        String searchName = sc.nextLine();
        for (int i = 0; i < comand.length; i++){
            if(comand[i].name.equals(searchName)){
                searchIndex = i;
            }
        }
        if(searchIndex!=-1){
            System.out.println("\nНайдена книга");
            System.out.println("Name:" + comand[searchIndex].name + "; " + "City:" + comand[searchIndex].city + "; "  + "Rating:" +
                    comand[searchIndex].rating + "; " + "Win streak:" + comand[searchIndex].winstreak + ";");
            System.out.println("\nВыберите поле которое хотите исправить");
            System.out.println("Name, City, Rating, Win streak");
            String redPole = sc.nextLine();
            switch (redPole){
                case "Name":{
                    System.out.println("New Name");
                    String newName = sc.nextLine();
                    comand[searchIndex].name = newName;
                    break;
                }
                case "City":{
                    System.out.println("New City");
                    String newCity = sc.nextLine();
                    comand[searchIndex].city = newCity;
                    break;
                }
                case "Rating":{
                    System.out.println("New Rating");
                    int newRating = sc.nextInt();
                    comand[searchIndex].rating = newRating;
                    break;
                }
                case "Win streak":{
                    System.out.println("New Streak");
                    int newStreak = sc.nextInt();
                    comand[searchIndex].rating = newStreak;
                    break;
                }
            }
            System.out.println("\nОтредактированная информация: ");
            System.out.println("Name:" + comand[searchIndex].name + "; " + "City:" + comand[searchIndex].city + "; "  + "Rating:" +
                    comand[searchIndex].rating + "; " + "Win streak:" + comand[searchIndex].winstreak + ";");
        }
        else{
            System.out.println("\nНичего не найдено");
        }
    }
}