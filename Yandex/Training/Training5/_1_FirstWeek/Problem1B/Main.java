package YandexTren.Training5.FirstWeek.Problem1B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day1 = scan.nextLine();
        String day2 = scan.nextLine();
        String place = scan.nextLine();
        String[] day1Arr = day1.split(":");
        String[] day2Arr = day2.split(":");

        int firstTeamDay1Res = Integer.parseInt(day1Arr[0]);
        int secondTeamDay1Res = Integer.parseInt(day1Arr[1]);
        int firstTeamDay2Res = Integer.parseInt(day2Arr[0]);
        int secondTeamDay2Res = Integer.parseInt(day2Arr[1]);
        boolean firstDayAtHome = Integer.parseInt(place) == 1;

        int firstTeamTotalRes = firstTeamDay1Res + firstTeamDay2Res;
        int secondTeamTotalRes = secondTeamDay1Res + secondTeamDay2Res;
        int ans;

        if (firstTeamTotalRes > secondTeamTotalRes) { // Выигрываем тотально
            ans = 0;
            System.out.println(ans);
        }
        else if (firstTeamTotalRes == secondTeamTotalRes) { //счет равен
            if (firstDayAtHome) {  // МЫ ДОМА первый день
                if (firstTeamDay1Res == secondTeamDay1Res) { //первый день ровно дома, значит вторые дни ровные
                    if (firstTeamDay2Res > secondTeamDay1Res) {    // Второй день мы в гостях и счет у нас лучше, чем у врага в гостях в первый день
                        ans = 0;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay2Res == secondTeamDay1Res) {
                        ans = 1;
                        System.out.println(ans);
                    }
                    else {
                        ans = 1;
                        System.out.println(ans);
                    }
                }
                else if (firstTeamDay1Res < secondTeamDay1Res) { //в первый день нас победили дома при равном счете
                    if (firstTeamDay2Res > secondTeamDay1Res) {
                        ans = 0;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay2Res == secondTeamDay1Res) {
                        ans = 1;
                        System.out.println(ans);
                    }
                    else {
                        ans = 1;
                        System.out.println(ans);
                    }
                }
                else { // В первый день победили мы дома, счет равен
                    if (firstTeamDay2Res > secondTeamDay1Res) {
                        ans = 0;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay2Res == secondTeamDay2Res) {
                        ans = 1;
                        System.out.println(ans);
                    }
                    else {
                        ans = 1;
                        System.out.println(ans);
                    }
                }
            }
            else { // Мы в гостях в первый день при равном счете
                if (firstTeamDay1Res == secondTeamDay1Res) { //первый день ровно в гостях
                    if (firstTeamDay1Res < secondTeamDay2Res) {
                        ans = 1;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay1Res > secondTeamDay2Res) {
                        ans = 0;
                        System.out.println(ans);
                    }
                    else {
                        ans = 1;
                        System.out.println(ans);
                    }
                }
                else if (firstTeamDay1Res < secondTeamDay1Res) { //в первый день нас победили в гостях, счет равный
                       // Во втором дне мы впереди дома, счет равный
                        if (secondTeamDay2Res > firstTeamDay1Res) {
                            ans = 1;
                            System.out.println(ans);
                        }
                        else if (secondTeamDay2Res == firstTeamDay1Res) {
                            ans = 1;
                            System.out.println(ans);
                        }
                        else {
                            ans = 0;
                            System.out.println(ans);
                        }
                }
                else { // В первый день победили мы в гостях, счет равный
                     // во второй день проигрываем дома
                        if (firstTeamDay1Res < secondTeamDay2Res) {
                            ans = 1;
                            System.out.println(ans);
                        }
                        else if (firstTeamDay1Res == secondTeamDay2Res) {
                            ans = 1;
                            System.out.println(ans);
                        }
                        else {
                            ans = 0;
                            System.out.println(ans);
                        }
                }
            }
        }
        else { // тотально проигрываем
            if (firstDayAtHome) { // первый день дома
                if (firstTeamDay1Res == secondTeamDay1Res) { //первый день ничья дома
                    if (firstTeamDay2Res > secondTeamDay1Res) {
                        ans = secondTeamDay2Res - firstTeamDay2Res;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay2Res == secondTeamDay1Res) {
                        ans = secondTeamDay2Res - firstTeamDay2Res;
                        System.out.println(ans);
                    }
                    else {      // firstTeamDay2Res < secondTeamDay1Res
                        if (secondTeamDay2Res > secondTeamDay1Res) {
                            ans = secondTeamDay2Res - firstTeamDay2Res;
                            System.out.println(ans);
                        }
                        else {
                            ans = (secondTeamDay2Res - firstTeamDay2Res) + 1;
                            System.out.println(ans);
                        }
                    }
                }
                else if (firstTeamDay1Res < secondTeamDay1Res) { //в первый день дома нас победили и тотально проигрываем
                    if (firstTeamDay2Res < secondTeamDay1Res) {
                        if (secondTeamDay1Res < secondTeamDay2Res) {
                            ans = secondTeamTotalRes - firstTeamTotalRes;
                            System.out.println(ans);
                        }
                        else if (secondTeamDay1Res == secondTeamDay2Res){
                            ans = (secondTeamTotalRes - firstTeamTotalRes);
                            System.out.println(ans);
                        }
                        else {
                            ans = (secondTeamTotalRes - firstTeamTotalRes);
                            System.out.println(ans);
                        }

                    }
                    else if (firstTeamDay2Res == secondTeamDay1Res) {
                        ans = (secondTeamTotalRes - firstTeamTotalRes);
                        System.out.println(ans);
                    }
                    else {
                        ans = secondTeamTotalRes - firstTeamTotalRes;
                        System.out.println(ans);
                    }
                }
                else { // В первый день победили мы дома при тотальном проигрыше, то есть во втором дне в гостях проигрываем.
                    if (firstTeamDay2Res > secondTeamDay1Res) {
                        ans = secondTeamTotalRes - firstTeamTotalRes;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay2Res == secondTeamDay1Res) {
                        ans = (secondTeamTotalRes - firstTeamTotalRes);
                        System.out.println(ans);
                    }
                    else {         // firstTeamDay2Res < secondTeamDay1Res     ! НАМ НАДО В ответе 3! (при 5:2  0:5, 1)  C ЭТОГО НАЧАТЬ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                        System.out.println(ans);
                    }
                }
            }
            else { // первый день в гостях, в целом тотально проигрываем
                if (firstTeamDay1Res == secondTeamDay1Res) { //первый день ровно в гостях
                    if (firstTeamDay1Res > secondTeamDay2Res) {
                        ans = secondTeamTotalRes - firstTeamTotalRes;
                        System.out.println(ans);
                    }
                    else if (firstTeamDay1Res == secondTeamDay2Res) {
                        ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                        System.out.println(ans);
                    }
                    else {
                        ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                        System.out.println(ans);
                    }
                }
                else if (firstTeamDay1Res < secondTeamDay1Res) { //в первый день нас победили в гостях, тотально проигрыш
                    if (firstTeamDay1Res < secondTeamDay2Res) { // Теперь враги в гостях
                        ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                        System.out.println(ans);

                    }
                    else if (firstTeamDay1Res == secondTeamDay2Res) {
                        ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                        System.out.println(ans);
                    }
                    else {
                        ans = secondTeamTotalRes - firstTeamTotalRes;
                        System.out.println(ans);
                    }
                }
                else { // В первый день победили в гостях при тотальном проигрыше
                         // Второй день дома теперь проигрываем firstTeamDay2Res < secondTeamDay2Res
                        if (firstTeamDay1Res > secondTeamDay2Res) {
                            ans = secondTeamTotalRes - firstTeamTotalRes;
                            System.out.println(ans);
                        }
                        else if (firstTeamDay1Res == secondTeamDay2Res) {
                            ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                            System.out.println(ans);
                        }
                        else {
                            ans = (secondTeamTotalRes - firstTeamTotalRes) + 1;
                            System.out.println(ans);
                        }
                }
            }
        }
    }
}