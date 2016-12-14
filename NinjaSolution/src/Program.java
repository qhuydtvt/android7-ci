import java.util.Iterator;
import java.util.Vector;

/**
 * Created by apple on 12/14/16.
 */
public class Program {
    public static void main(String[] args) {
        Ninja naruto = new Ninja(
                "Naruto",
                "Leaf",
                10, 2, 4
        );


        Ninja sasuke = new Ninja(
                "Sasuke",
                "Leaf",
                9, 9, 6
        );

        Ninja levi = new Ninja(
                "Levi",
                "Fog",
                5, 6, 7
        );

        Ninja gaara = new Ninja(
                "Gaara",
                "Sand",
                6, 7, 5
        );

        Vector<Ninja> ninjas = new Vector<Ninja>();
        ninjas.add(naruto);
        ninjas.add(sasuke);
        ninjas.add(levi);
        ninjas.add(gaara);



        boolean gameOn = true;
        int index = 0;
        while(gameOn) {

            for (int i = 0; i < ninjas.size();i ++) {
                if (!ninjas.get(i).isAlive()) {
                    continue;
                }
                Ninja attacker = ninjas.get(i);
                Ninja defender;
                if (i == ninjas.size() - 1) {
                    defender = ninjas.get(0);
                } else {
                    defender = ninjas.get(i + 1);
                }
                System.out.println("Before attack");
                attacker.print();
                defender.print();
                attacker.attack(defender);
                System.out.println("After attack");
                attacker.print();
                defender.print();

            }

            Iterator<Ninja> iterator = ninjas.iterator();
            while(iterator.hasNext()) {
                Ninja ninja = iterator.next();
                if (!ninja.isAlive()) {
                    iterator.remove();
                }
            }

//            Vector<Ninja> deadNinjas = new Vector<>();
//
//            for(Ninja ninja : ninjas) {
//                if (!ninja.isAlive()) {
//                    //ninjas.remove(ninja);
//                    deadNinjas.add(ninja);
//                }
//            }
//
//            //System.out.println("********************************");
//            //printAll(ninjas);
//            //System.out.println("-------------------------------");
//            ninjas.removeAll(deadNinjas);
//            //printAll(ninjas);
//
////            for(Ninja ninja: deadNinjas) {
////                ninjas.remove(ninja);
////            }

            if(ninjas.size() == 1) {
                gameOn = false;
            }
        }

        System.out.println("Done");
        System.out.println(String.format("%s", ninjas.size()));
        System.out.println(ninjas.get(0));


//        for (Ninja ninja : ninjas) {
//            System.out.println(ninja);
//        }

        //naruto.attack(sasuke);

        //naruto.print();
        //sasuke.print();

//        for(int i  = 0; i < ninjas.length; i++) {
//            Ninja attacker = ninjas[i];
//            Ninja defender;
//            if(i == ninjas.length - 1)
//                defender = ninjas[0];
//            else
//                defender = ninjas[i+1];
//            System.out.println("Before attack");
//            attacker.print();
//            defender.print();
//
//            attacker.attack(defender); // Zooo
//            System.out.println("After attack");
//
//            attacker.print();
//            defender.print();
//        }



        //1
        //attack(naruto, gaara);

        //attack(gaara, naruto);
    }
    static private void printAll(Vector<Ninja> ninjaVector) {
        for (Ninja ninja : ninjaVector) {
            ninja.print();
        }
    }

//    public static void attack(Ninja attacker, Ninja defender) {
//        if(attacker .getAtk() > defender.getDef()) {
//            int dam = attacker .getAtk() - defender.getDef();
//            defender.setHp(defender.getHp() - dam);
//        }
//    }
//
//    public static void support(Ninja ninja1, Ninja ninja2) {
//
//    }
}
