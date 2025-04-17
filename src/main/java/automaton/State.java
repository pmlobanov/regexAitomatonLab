package automaton;

import java.util.HashMap;
import java.util.Map; /**
 * Represents a state in a Deterministic Finite Automaton (DFA).
 */
public class State {
    private String name;
    private boolean isAccepting;
    private Map<Character, State> transitions;

    /**
     * Creates a new state with the given name.
     *
     * @param name The name of the state
     * @param isAccepting Whether this state is an accepting state
     */
    public State(String name, boolean isAccepting) {
        this.name = name;
        this.isAccepting = isAccepting;
        this.transitions = new HashMap<>();
    }

    public Map<Character, State> getTransitions() {
        return transitions;
    }

    /**
     * Adds a transition from this state to another state on the given symbol.
     *
     * @param symbol The input symbol
     * @param nextState The state to transition to
     */
    public void addTransition(char symbol, State nextState) {
        transitions.put(symbol, nextState);
    }

    /**
     * Gets the next state for the given input symbol.
     *
     * @param symbol The input symbol
     * @return The next state, or null if no transition exists
     */
    public State getNextState(char symbol) {
        return transitions.get(symbol);
    }

    /**
     * Checks if this state is an accepting state.
     *
     * @return true if this is an accepting state, false otherwise
     */
    public boolean isAccepting() {
        return isAccepting;
    }

    /**
     * Gets the name of this state.
     *
     * @return The name of this state
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + (isAccepting ? " (accepting)" : "");
    }
}
