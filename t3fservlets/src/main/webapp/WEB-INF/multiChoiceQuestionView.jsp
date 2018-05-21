<%@ page import="com.t3f.model.MultiChoiceQuestion" %>
<%@ page import="java.util.List" %>

<% MultiChoiceQuestion question = (MultiChoiceQuestion)request.getSession().getAttribute("question"); %>
<% List<String> possibleAnswers = question.getAllPossibleAnswersShuffled(); %>

<form action="answer" method="post">
    <%=question.getQuestion()%> = ? <br>
    <input type="radio" name="proposedAnswer" value="<%=possibleAnswers.get(0)%>"><%=possibleAnswers.get(0)%><br>
    <input type="radio" name="proposedAnswer" value="<%=possibleAnswers.get(1)%>"><%=possibleAnswers.get(1)%><br>
    <input type="radio" name="proposedAnswer" value="<%=possibleAnswers.get(2)%>"><%=possibleAnswers.get(2)%><br>
    <input type="submit" value="submit"/>
</form>