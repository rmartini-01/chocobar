package chocobar;

public class PlaqueDeChocolat {
    protected boolean[][] plaque;
    protected int carreMange;


    public void setCarreMange(int carreMange) {
        this.carreMange = carreMange;
    }

    public PlaqueDeChocolat(){
        plaque = new boolean[10][10]; //taille maximum possible
        carreMange = 0;
        for (int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                plaque[i][j] = true; // par défaut, les boutons sont visibles
            }
        }
    }

    public boolean getCarre(int i, int j){
        return plaque[i][j];
    }

    public int getCarreMange() {
        return carreMange;
    }

    public void setPlaqueFalse(int i, int j) {
        for(int k = i; k<10; k++){
            for(int l = j; l<10; l++){
                if(plaque[k][l]){
                    plaque[k][l]= false;
                    carreMange++;
                    //System.out.println("CarreMange =  " +carreMange);
                }
            }
        }
    }
    public void setPlaqueTrue(){
        for(int i = 0; i<10; i++){
            for (int j=0; j<10; j++){
                plaque[i][j] = true;
            }
        }
    }


    public boolean isFinDePartie(){
        for(int i = 0; i<10; i++){
            for( int j = 0; j<10; j++){
                if(!this.plaque[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
