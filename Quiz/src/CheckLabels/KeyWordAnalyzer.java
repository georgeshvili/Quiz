package CheckLabels;

abstract class KeyWordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeyWords();

    protected abstract Label getLabel();

    public Label processText(String textToCheck){
        String[] keyWords = getKeyWords();
        for(String keyWord : keyWords){
            if(textToCheck.contains(keyWord)){
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeyWordAnalyzer {

    private String[] keyWords;

    public SpamAnalyzer (String[] keyWords){
        this.keyWords = keyWords;
    }

    @Override
    protected String[] getKeyWords(){
        return keyWords;
    }

    @Override
    protected Label getLabel(){
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeyWordAnalyzer {

    private String[] keyWords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeyWords(){
        return keyWords;
    }

    @Override
    protected Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    public TooLongTextAnalyzer(int threshold) {
        this.maxLength = threshold;
    }

    @Override
    public Label processText(String textToCheck) {
        if (textToCheck.length() > maxLength)
            return Label.TOO_LONG;
        else
            return Label.OK;
    }
}
