package YandexTren.Training5.FirstWeek.Problem1G;

import java.util.Scanner;

public class Main {
    static double mySolders;
    static double barakHealth;
    static double soldiersProduction;
    static double enemySoldiers;
    static int countRounds;
    static double damage;
    static final double goldSech = (1 + Math.sqrt(5)) / 2;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        mySolders = Double.parseDouble(scan.nextLine());
        barakHealth = Double.parseDouble(scan.nextLine());
        soldiersProduction = Double.parseDouble(scan.nextLine());
        scan.close();
        enemySoldiers = 0;
        countRounds = 0;
        damage = 0;

        boolean nowHit = false;

        if (barakHealth >= 2 * mySolders && mySolders <= soldiersProduction) {
            System.out.println(-1);
            return;
        }
                while (mySolders > 0 && (barakHealth > 0 || enemySoldiers > 0)) {
                    // Если начнем бить казарму сейчас или на следующем ходу, то победим ли
                    if ( (goldSech > (((barakHealth + soldiersProduction) / mySolders)))) {
                        while (mySolders > 0 && (barakHealth > 0 || enemySoldiers > 0)) {
                            if ( ( (standardMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds) <          //Если стандартно добивать и бить
                                    hitBarakMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds)) &&      //выгоднее, чем вложиться в казарму
                                    (standardMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds) != -1) ) ) {
                                reWriteStandardMethod();
                            }
                            else {  // Надо проверить может выгоднее все равно вложиться сначала в стандартную тактику разок
                                if (nowHit || standardMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds) == -1
                                        // выгоднее хит барак, чем (стандарт, а потом хитбарак).
                                        || (hitBarakMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds) <
                                        standardAndThenHitBarakMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds)) &&
                                        hitBarakMethod(mySolders, barakHealth, soldiersProduction, enemySoldiers, countRounds) != -1) {
                                        reWriteHitBarakMethod();
                                }
                                else {
                                    reWriteStandardMethod();
                                    nowHit = true;
                                }
                            }
                        }
                        if (0 >= mySolders) {
                            System.out.println(-1);
                        }
                        else {
                            System.out.println(countRounds);
                        }
                        return;
                    }
                    else {  // Значит пока вкладываться в казарму совсем рано
                        if (enemySoldiers != 0) {
                            if (enemySoldiers >= mySolders) {
                                System.out.println(-1);
                                return;
                            }
                            enemySoldiers -= mySolders;
                            if (enemySoldiers <= 0) {
                                damage = Math.abs(enemySoldiers);
                                enemySoldiers = 0;
                                barakHealth -= damage;
                            }
                            mySolders -= enemySoldiers;
                            if (barakHealth > 0) {
                                enemySoldiers += soldiersProduction;
                            }
                            countRounds++;
                        }
                        else {
                            barakHealth -= mySolders;
                            if (barakHealth > 0) {
                                enemySoldiers += soldiersProduction;
                            }
                            countRounds++;
                        }
                    }
                }
                if (0 >= mySolders) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(countRounds);
                }
    }

    public static int standardMethod(double mySolders, double barakHealth, double soldiersProduction, double enemySoldiers, int countRounds) {
        double damage = 0;
        if (enemySoldiers == mySolders) {
            return -1;
        }
        while ((mySolders > 0 && (barakHealth > 0 || enemySoldiers > 0))) {
                if (enemySoldiers != 0) {
                    enemySoldiers -= mySolders;
                    if (enemySoldiers <= 0) {
                        damage = Math.abs(enemySoldiers);
                        enemySoldiers = 0;
                        barakHealth -= damage;
                    }
                    mySolders -= enemySoldiers;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
                else {
                    barakHealth -= mySolders;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
        }
        if (0 >= mySolders) {
            return -1;
        }
        else {
            return countRounds;
        }
    }
    public static int hitBarakMethod(double mySolders, double barakHealth, double soldiersProduction, double enemySoldiers, int countRounds) {
        double damage = 0;
        while (mySolders > 0 && (barakHealth > 0 || enemySoldiers > 0)) {
            barakHealth -= mySolders;
            if (barakHealth < 0) {
                damage = Math.abs(barakHealth);
                barakHealth = 0;
                enemySoldiers -= damage;
                if (enemySoldiers < 0){
                    enemySoldiers = 0;
                }
            }
            mySolders -= enemySoldiers;
            if (barakHealth > 0) {
                enemySoldiers += soldiersProduction;
            }
            countRounds++;
        }
        if (0 >= mySolders) {
            return -1;
        }
        else {
            return countRounds;
        }
    }
    public  static int standardAndThenHitBarakMethod(double mySolders, double barakHealth, double soldiersProduction, double enemySoldiers, int countRounds) {
        double damage = 0;
        boolean stdDone = false;
        while ((mySolders > 0 && (barakHealth > 0 || enemySoldiers > 0))) {
            if (!stdDone) {
                if (enemySoldiers != 0) {
                    enemySoldiers -= mySolders;
                    if (enemySoldiers <= 0) {
                        damage = Math.abs(enemySoldiers);
                        enemySoldiers = 0;
                        barakHealth -= damage;
                    }
                    mySolders -= enemySoldiers;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
                else {
                    barakHealth -= mySolders;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
                stdDone =true;
            }
            else {
                barakHealth -= mySolders;
                if (barakHealth < 0) {
                    damage = Math.abs(barakHealth);
                    barakHealth = 0;
                    enemySoldiers -= damage;
                    if (enemySoldiers < 0){
                        enemySoldiers = 0;
                    }
                }
                mySolders -= enemySoldiers;
                if (barakHealth > 0) {
                    enemySoldiers += soldiersProduction;
                }
                countRounds++;
            }
        }
        if (0 >= mySolders) {
            return -1;
        }
        else {
            return countRounds;
        }
    }
    public static void reWriteStandardMethod() {
        double damage = 0;
                if (enemySoldiers != 0) {
                    enemySoldiers -= mySolders;
                    if (enemySoldiers <= 0) {
                        damage = Math.abs(enemySoldiers);
                        enemySoldiers = 0;
                        barakHealth -= damage;
                    }
                    mySolders -= enemySoldiers;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
                else {
                    barakHealth -= mySolders;
                    if (barakHealth > 0) {
                        enemySoldiers += soldiersProduction;
                    }
                    countRounds++;
                }
    }
    public static void reWriteHitBarakMethod() {
            double damage = 0;
            barakHealth -= mySolders;
            if (barakHealth < 0) {
                damage = Math.abs(barakHealth);
                barakHealth = 0;
                enemySoldiers -= damage;
                if (enemySoldiers < 0){
                    enemySoldiers = 0;
                }
            }
            mySolders -= enemySoldiers;
            if (barakHealth > 0) {
                enemySoldiers += soldiersProduction;
            }
            countRounds++;
    }
}