package library;

public interface Menu {
    public void showOptions();
    public boolean isChoiceValid(String option);
    public String getChoice();
    public void handleChoice(String choice);
}
