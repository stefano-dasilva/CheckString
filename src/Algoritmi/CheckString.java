package Algoritmi;

import Addestramento.Addestramento;
import Assets.DBmock;
import Config.FactoryUtil;
import Model.Corrispondenza;
import Model.NonTrovata;
import Model.Standard;


public abstract class CheckString {

  //  private Collection<Standard> standards;
    private CheckString next;
    // RIFERIMENTO DELLA CLASSE ADDESTRAMENTO
    private Addestramento datiAddestramento;
   // private  LangDetector detector;




    public Corrispondenza check(String input) {
     //   standards = new ArrayList<>();
      //  tokenizer = new Tokenizer();
      //  detector= new LangDetector();

        FactoryUtil factoryUtil = FactoryUtil.getIstanza();

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + input);



/*
        if (detector.detectLanguage(input).equalsIgnoreCase("en") || datiAddestramento != null){
            ParoleStandard paroleStandard = new StandardFromDB();
            this.standards = paroleStandard.getStandards();
           // System.out.println("altro");
        }
        else{
            ParoleStandard paroleStandard = new StandardFromFile();
            this.standards = paroleStandard.getStandards();
          //  System.out.println("italiano");
        }



        ArrayList<String> paroleSimili = new ArrayList<>();

        ArrayList<String> inputTokenizzato = new ArrayList();
        inputTokenizzato.addAll(tokenizer.getTokens(input));

         */
        Corrispondenza corrispondenza = implementcheck(input);
        if(corrispondenza != null){
            // non c'è un addestramento
            if(datiAddestramento == null){
                factoryUtil.getCorrispondenzaDao().add(corrispondenza);

                return  corrispondenza;
/*
                Standard standard = corrispondenza.getStandard();
                standard.setNumRicerche(standard.getNumRicerche() + 1);


                DBmock.getIstanza().putRicorrenza(input, corrispondenza.getStandard());
                return corrispondenza;

 */

            }
            else {
                String chiave = this.getClass().getSimpleName();
                // IL VALORE è PRESO CON GETORDEFAULT : SE LA CHIAVE NON è ANCORA PRESENTE
                // PERCHè NON è STATO ANCORA INSERITO ALCUN CASO DI SUCCESSO ALLORA IL VALORE è 0
                // SE NO è IL VALORE CONTENUTO DALLA CHIAVE;
                int valore = DBmock.getIstanza().getCasiSuccesso().getOrDefault(chiave,0);
                DBmock.getIstanza().getCasiSuccesso().put(chiave,valore + 1);
                // System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " +
                if(next != null){
                return next.check(input);
                }
                else
                    return null;
            }
        }
        else if (next != null) {
            //     System.out.println("procedo con il successivo\n");
            return next.check(input);
        } else {
            NonTrovata nonTrovata = new NonTrovata();
            nonTrovata.setInput(input);
            factoryUtil.getNonTrovataDao().add(nonTrovata);
            return null;
        }






        /*

        if(check(input, ) )
        // PRIMA DI SVOLGERE TUTTI GLI ALGORITMI CONTROLLO SE ALL'INTERNO DELLE
        // RICORRENZE PRESENTI NEL DBMOCK ( LA SIMULAZIONE DEL DB
        // HO GIà LA RICORRENZA, SE CE L'HO NON USO GLI ALGORITMI
        // QUESTO CONTROLLO IN PRATICA CHIEDE SE NELLA STRUTTURA RICORRENZE
        // C'è UNA CHIAVE CHE è UGUALE AL VALORE DELL'INPUT INSERITO
        // ESEMPIO : è STATA INSERITA UNA RICORRENZA CON CHIAVE FILI?

        /*
        if(DBmock.getIstanza().getRicorrenze().containsKey(input)){

            ArrayList<String> riccorenza = new ArrayList<>();
            riccorenza.add( DBmock.getIstanza().getRicorrenze().get(input));
            return riccorenza;
        }

        // TOKENIZZO L'INPUT IN INGRESSO USANDO DEI VINCOLI
        // ESEMPIO REPUBBLICA CECA -> CECA
        // LE PAROLE NON CONSIDERATI DAL TOKEN SONO PRESENTI IN ASSETS->LETTEREBANDITE.TXT


        for(String tokenized : inputTokenizzato){
           // System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + tokenized);

            // CONFRONTO I TOKEN CON LA LISTA DI PAROLE
            for (Standard standard : standards) {
                ArrayList<String> standardTokenizzato = new ArrayList();
                standardTokenizzato.addAll(tokenizer.getTokens(standard.getValue()));
                // TOKENIZZO ANCHE LA SINGOLA NAZIONE DELLA LISTA DI NAZIONI
                // IN MODO CHE LA PARTE "CECA" DELL'INPUT NON VENGA CONFRONTATA CON
                // REPUBBLICA CECA MA CON "CECA"
                for(String standardToken : standardTokenizzato){
                if (check(tokenized, standardToken)) {
                    parolaTrovata = true;
                //    System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName());
                    //  System.out.println(input + " --> " + standard.getValue());


                    if (datiAddestramento == null) {
                        // AGGIUNGE NELLA STRUTTURA DATI DELLE RICORRENZE UN CASO
                        // ES FILI->FILIPPINE
                      //  dbmock = DBmock.getIstanza();
                       // dbmock.putRicorrenza(input, standard.getValue());
                        // AGGIUNGE AD UNA LISTA CHIAMATA PAROLE SIMILI
                        // TUTTE LE PAROLE CHE HANNO UNO SCORE SUPERIORE ALLA SOGLIA
                        // CALCOLATA DAI VARI ALGORITMI
                        paroleSimili.add(standard.getValue());
                        // return true;
                    } else {
                        // AGGIUNGE NELLA MAPPA CHE MOSTRA I CASI SUCCESSO DI OGNI ALGORITMO
                        // (PRESENTE IN CLASSE ADDESTRAMENTO ) UN CASO DI SUCCESSO
                        // ESEMPIO LEVENSTEIN->3
                        //         JARO-> 4 ECC
                        // LA CHIAVE è IL NOME DELL'ALGORITMO
                        System.out.println("sono in algoritmo " + this.getClass().getSimpleName() + "la parola " + tokenized + "trovata parola " + standardToken);

                        String chiave = this.getClass().getSimpleName();
                        // IL VALORE è PRESO CON GETORDEFAULT : SE LA CHIAVE NON è ANCORA PRESENTE
                        // PERCHè NON è STATO ANCORA INSERITO ALCUN CASO DI SUCCESSO ALLORA IL VALORE è 0
                        // SE NO è IL VALORE CONTENUTO DALLA CHIAVE
                        int valore = getDatiAddestramento().getCasiSuccesso().getOrDefault(chiave, 0);
                        getDatiAddestramento().getCasiSuccesso().put(chiave, valore + 1);
                       // System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " + valore);
                        break;
                    }
                }
            }
                if(parolaTrovata && datiAddestramento != null){
                    break;
                }

        }
    }
        // SE LA PAROLA SIMILE è STATA TROVATA FA UN CONTROLLO:
        if (parolaTrovata) {
            boolean parolaEsatta = false;
            // PER OGNI PAROLA SIMILE CHE VIENE TROVATA CONTROLLA SE
            // LA PAROLA SIMILE è UGUALE ALLA PAROLA ESATTA
            // ESEMPIO : SE SCRIVO IRAN PAROLE SIMILI POSSONO ESSERE IRAN E IRAQ
            for( String parolasimile : paroleSimili){
             //   System.out.println(parolasimile);
                if(parolasimile.equalsIgnoreCase(input)){
                    parolaEsatta = true;
                }
            }
          //  System.out.println("Forse cercavi : ");

            if(parolaEsatta){
                // SE LA PAROLA SIMILE è ESATTAMENTE UGUALE A CIO CHE HO MESSO IN INPUT
                // RESTITUISCE SOLO QUELLA PAROLA : QUINDI TRA IRAN E IRAQ RESTITUISCE
                // IRAN SE HO SCRITTO IRAN O IRAQ SE HO SCRITTO IRAQ
             //   System.out.println(input);
                ArrayList<String> risultato = new ArrayList<>();
                risultato.add(input);
                return  risultato;
            }
            else{
                // QUESTO è IL RAMO IN CUI ENTRO SE LA PAROLASIMILE!= PAROLA INSERITA IN INPUT
                // SE C'è UNA LISTA DI PAROLE SIMILI LE RESTITUISCE TUTTE,
                // ( MA SPESSO LA PAROLA IL CUI SCORE SUPERA LA SOGLIA è SOLO UNA
                // QUINDI A VOLTE VIENE RESTITUITO GIUSTAMENTE UN ARRAYLIST DI 1 ELEMENTO
                // ESEMPIO BRAZIL -> BRASILE

                // QUI PER OGNI STRINGA SIMILE CON PIU PAROLE TIPO UNITED STATES ECC ECC
                // CONTA SE IL NUMERO DI PAROLE SIMILI AL SUO INTERNO SIA UGUALE AL NUMERO
                //  DI PAROLE CONTENUTE NELLA PAROLA STANDARD
                // QUINDI UNITED STATES OF AMERICA  HA DUE PAROLE SIMILI A UNITED STATES
                // IL NUMERO DI PAROLE DI UNITED STATES è DUE, QUINDI VA A DARE COME RISULTATO SOLO QUELLA
                for( String parolasimile : paroleSimili) {
                    int numParoleSimili = 0;
                    ArrayList<String> standardTokenizzato = new ArrayList();
                    standardTokenizzato.addAll(tokenizer.getTokens(parolasimile));
                    ArrayList<String> provaarray = new ArrayList<>();
                    provaarray.addAll(tokenizer.getTokens(input));
                    for(String prova : provaarray ){
                        for(String standard : standardTokenizzato){
                            if( check(prova,standard)){
                                numParoleSimili = numParoleSimili + 1;
                            }
                        }
                    }
                    if( numParoleSimili == standardTokenizzato.size()){
                        ArrayList<String> risultato = new ArrayList<>();
                        risultato.add(parolasimile);
                        return  risultato;
                    }

                    // TESTING
                     //   System.out.println(parolasimile);
                }


            }
            return paroleSimili;
        } else if (next != null) {
       //     System.out.println("procedo con il successivo\n");
            return next.check(input);
        } else {
            return null;
        }

         */

    }
    protected String getName(){
        return this.getClass().getSimpleName();
    }

    public void setNext(CheckString checkString){
        this.next = checkString;
    }

    public void setDatiAddestramento(Addestramento datiAddestramento) {
        this.datiAddestramento = datiAddestramento;
    }




    // TEMPLATE
    protected abstract Corrispondenza implementcheck(String input);



}
