package at.htl.todo.model;

import javax.inject.Inject;
import javax.inject.Singleton;

/** This is our Storage area for <a href="https://redux.js.org/understanding/thinking-in-redux/three-principles">single source of truth</a> {@link Model}. */
import at.htl.todo.util.store.Store;

@Singleton
public class ModelStore extends Store<Model>  {

    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setTodos(Todo[] todos) {
        apply(model -> model.todos = todos);
    }
    public void selectedTab(int tabIndex) {
        apply(model -> model.uiState.selectedTab = tabIndex);
    }
    public void setToDone(Todo todo, boolean isDone) {
        apply(model -> model.todos[todo.id.intValue()-1].completed = isDone);
    }
}
