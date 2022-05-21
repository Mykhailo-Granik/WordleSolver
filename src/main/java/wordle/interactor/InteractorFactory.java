package wordle.interactor;

public class InteractorFactory {

    public Interactor create() {
        return new EasyModeInteractor();
    }

}
