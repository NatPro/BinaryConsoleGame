package view;

public aspect InputHandlerAspect {

    pointcut callReadInputFromConsole(InputHandler handler) : call(boolean InputHandler.readInputFromConsole()) target(handler);

    after(InputHandler balance) : readInputFromConsole() {
    }
}