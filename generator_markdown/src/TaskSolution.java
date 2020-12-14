public class TaskSolution {
    private String title = null;
    private String link = null;
    private String sourceCode = null;
    // получение и присваивание

    String getTitle() {return this.title;
    }

    String getLink() {return this.link;
    }

    String getSourceCode() {return this.sourceCode;
    }

    final void setTitle(String title) {this.title = title;
    }

    final void setLink(String link) {this.link = link;
    }

    final void setSourceCode(String sourceCode) {this.sourceCode = sourceCode;
    }
}
