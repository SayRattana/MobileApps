package homeworkpart3;

import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class Main {

    public static void main(String[] args) {
        // For Table         
        Table[] tables = new Table[10];
        Random random = new Random();   
            for (int i = 0; i<10; i++){
                tables[i] = new Table(random.nextInt(50), random.nextInt(200));
                System.out.println("Table "+(i+1));
                tables[i].showData();
            }
           
        //For PhotoAlbum
        PhotoAlbum[] photoalbums = new PhotoAlbum[16];            
            for (int j =0; j<16; j++){
                photoalbums [j]=new PhotoAlbum(j+1); 
                System.out.println("PhotoAlbum"+(j+1)+photoalbums[j]);
            }
 



        }

         
         
         
    }
    

