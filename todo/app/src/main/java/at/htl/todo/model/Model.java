package at.htl.todo.model;

import java.util.List;

public class Model {
    public static class UIState {
        public int selectedTab = 0;
    }
    public UIState uiState = new UIState();
    public Todo[] todos = new Todo[0];
}