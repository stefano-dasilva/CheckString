package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;
import Addestramento.Addestramento;
import Assets.DBmock;
import ParoleStandard.ParoleStandard;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;
import ParoleStandard.StandardFromDB;
import ParoleStandard.StandardFromLocale;



public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;
    // RIFERIMENTO DELLA CLASSE ADDESTRAMENTO
    private Addestramento datiAddestramento;
    private DBmock dbmock;
    private Tokenizer tokenizer;
    private boolean parolaTrovata;
    private  LangDetector detector;



    public ArrayList<String> check( String input) {
        standards = new ArrayList<>();
        tokenizer = new Tokenizer();
        detector= new LangDetector();

        String detectedLanguage = detector.detectLanguage(input);
        if (detector.detectLanguage(input).equalsIgnoreCase("it")){
            ParoleStandard paroleStandard = new StandardFromLocale();
            this.standards = paroleStandard.getStandards();
        }else{
            if (detector.detectLanguage(input).equalsIgnoreCase("en")) {
                ParoleStandard paroleStandard = new StandardFromFile();
                this.standards = paroleStandard.getStandards();
            }
        }


        ArrayList<String> paroleSimili = new ArrayList<>();
        ArrayList<String> inputTokenizzato = new ArrayList();
        inputTokenizzato.addAll(tokenizer.getTokens(input));

        /*
        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

         */
        /*
        ParoleStandard paroleStandard1 = new StandardFromDB();
        this.standards = paroleStandard1.getStandards();

         */

        parolaTrovata = false;
        // PRIMA DI SVOLGERE TUTTI GLI ALGORITMI CONTROLLO SE ALL'INTERNO DELLE
        // RICORRENZE PRESENTI NEL DBMOCK ( LA SIMULAZIONE DEL DB
        // HO GIà LA RICORRENZA, SE CE L'HO NON USO GLI ALGORITMI
        // QUESTO CONTROLLO IN PRATICA CHIEDE SE NELLA STRUTTURA RICORRENZE
        // C'è UNA CHIAVE CHE è UGUALE AL VALORE DELL'INPUT INSERITO
        // ESEMPIO : è STATA INSERITA UNA RICORRENZA CON CHIAVE FILI?
        if(DBmock.getIstanza().getRicorrenze().containsKey(input)){

            ArrayList<String> riccorenza = new ArrayList<>();
            riccorenza.add( DBmock.getIstanza().getRicorrenze().get(input));
            return riccorenza;
        }

        // TOKENIZZO L'INPUT IN INGRESSO USANDO DEI VINCOLI
        // ESEMPIO REPUBBLICA CECA -> CECA
        // LE PAROLE NON CONSIDERATI DAL TOKEN SONO PRESENTI IN ASSETS->LETTEREBANDITE.TXT
        for(String tokenized : inputTokenizzato){
            System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + tokenized);

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
                for( String parolasimile : paroleSimili) {
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

    public Addestramento getDatiAddestramento() {
        return datiAddestramento;
    }

    public Collection<Standard> getStandards() {
        return standards;
    }

    // TEMPLATE
    protected abstract boolean check(String input, String standard);



}
