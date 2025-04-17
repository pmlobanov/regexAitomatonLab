package regexLab.main;

import regexLab.main.postalCodeAutomatons.IcelandPostalCodeAutomaton;

public class Main {
    public static void main(String[] args) {
        IcelandPostalCodeAutomaton icelandAutomaton = new IcelandPostalCodeAutomaton();
        System.out.println(icelandAutomaton.accepts("902"));
        System.out.println(icelandAutomaton.generateAcceptableString());
        System.out.println(icelandAutomaton.accepts(icelandAutomaton.generateAcceptableString()));
        System.out.println("Hello, World!");
    }
}