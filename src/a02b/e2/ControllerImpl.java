package a02b.e2;

public class ControllerImpl implements Controller{

    private final Asterisk ast;
    private final GUI gui;

    public ControllerImpl(final GUI gui, final Asterisk ast) {
        this.gui = gui;
        this.ast = ast;
    }

    @Override
    public void buttonClicked() {
        this.ast.move();
        this.gui.updateState();
    }
    
}
