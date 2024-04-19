import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Message{
    private String messageSender;
    private List<String> recipients;
    private String timestamp;
    private String messageContent;

    public Message(String messageSender, List<String> recipients, String timestamp, String messageContent){
        this.messageSender = messageSender;
        this.recipients = recipients;
        this.timestamp = timestamp;
        this.messageContent = messageContent;
    }

    public String getMessageSender(){return messageSender;}
    public List<String> getRecipients(){return recipients;}
    public String getTimestamp(){return timestamp;}
    public String getMessageContent(){return messageContent;}

}

class User implements Iterable<Message>{
    public String username;
    public ChatServer chatServer;
    public ChatHistory chatHistory;

    public User(String username, ChatServer chatServer){
        this.username = username;
        this.chatServer = chatServer;
        this.chatHistory = new ChatHistory();
    }

    public void sendMessageToServer(List<String> recipients, String messageContent){
        chatServer.sendMessage(this.username, recipients, messageContent);
    }
    public void receiveMessage(Message message){
        if(!message.getMessageSender().equals(username)){
            chatHistory.addMessageToHistory(message); //adds the message send to message history;
            System.out.println("Message: " + message.getMessageContent() + "\n\tMessage Sender: " + message.getMessageSender() + "\n\tTime of Message: " + message.getTimestamp());
        }

    }

    public void undoMessage(){
        Message lastMessage = chatHistory.getLastMessage();//gets the last message in the chat history from ChatHistory class
        if(lastMessage.getMessageSender().equals(username)){ //if the sender of the last message is the current username
            chatServer.undoMessage(this.username, lastMessage); //undo the message from the chat server
            chatHistory.removeLastMessage();//removes the message from the chat history
            System.out.println("Message removed");
        }
        else{
            System.out.println("No messages to undo");
        }
    }

    public void blockUser(String userBlocked){
        chatServer.blockUser(this.username, userBlocked);
        System.out.println("Messages Blocked");
    }

    public void viewChatHistory(){
        chatHistory.printChatHistory();
    }

    @Override
    public Iterator<Message> iterator(){
        return chatHistory.iterator(this);
    }

    public Iterator<Message> iterator(String userToSearchWith){
        return new SearchMessagesByUser(chatHistory, userToSearchWith);
    }

}

class ChatServer{
    private List<User> users;
    private List<List<String>> blockedUsers;

    public ChatServer(){
        this.users = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public void registeruser(User user){ //Method to register user
        users.add(user);
        System.out.println(user.username + " has been registered as a user");
    }
    public void unregisterUser(User user){ //Method to unregister user
        users.remove(user);
        System.out.println(user.username + " has been unregistered as a user");
    }

    public void undoMessage(String username, Message message){
        for(User user : users){
            if(user.username.equals(username)){
                user.receiveMessage(message);
                break;
            }
        }
    }


    public void sendMessage(String sender, List<String> recipients, String messageContent){ //Method to send message to user
        Message message = new Message(sender, recipients, "6:30 PM", messageContent);
        for(User user : users)
            if(!checkUserBlock(user.username, sender)){ //if the user is not blocked
                user.receiveMessage(message); //that user will receive the message
            }



    }

    public boolean checkUserBlock( String userBlocking, String username){
        for(int i = 0; i < users.size(); i++){// iterating through the list of users
            if(users.get(i).username.equals(username)){
                if(i != -1 && blockedUsers.size() > 1){ //if there are more than 0 blocked users in the blockedUser list
                    List<String> blockedList = blockedUsers.get(i);
                    return blockedList.contains(userBlocking);
                }
            }
        }
        return false;
    }
    public void blockUser(String userBlocking, String blockedUser ){
        for(int i = 0; i < users.size(); i++){ //iterating through the list of users
            if(users.get(i).username.equals(userBlocking)){ //if the username in the list of users is equal to userBlocking
                if(i != -1){
                    List<String> blockedList = blockedUsers.get(i);
                    if(blockedList == null){
                        blockedList = new ArrayList<>();
                        blockedUsers.add(i, blockedList);
                    }
                    blockedList.add(blockedUser);
                }
            }
        }
    }
}

class ChatHistory implements IterableByUser{
    public List<Message> messageList;

    public ChatHistory(){
        this.messageList = new ArrayList<>();
    }
    public void addMessageToHistory(Message message){
        messageList.add(message); //add message object to messageList list
    }
    public Message getLastMessage() {
        return messageList.get(messageList.size() - 1); //gets the size of the messageList and gets the last item
    }

    public void removeLastMessage(){
        if(!messageList.isEmpty()){
            messageList.remove(messageList.size() - 1);
        }
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith){
        return new SearchMessagesByUser(this, userToSearchWith.username);
    }

    public void printChatHistory(){
        for(Message message: messageList){
            System.out.println(message.getMessageSender() + " to " + message.getRecipients() + ": " + message.getMessageContent());
        }
    }

}

interface IterableByUser{
    Iterator<Message> iterator(User userToSearchWith);
}

class SearchMessagesByUser implements Iterator<Message>{
    private Iterator<Message> iterator;
    private String userToSearchWith;

    public SearchMessagesByUser(ChatHistory chatHistory, String userToSearchWith){
        this.iterator = chatHistory.messageList.iterator();
        this.userToSearchWith = userToSearchWith;
    }

    @Override
    public boolean hasNext(){
        while(iterator.hasNext()){
            Message nextMessage = iterator.next();
            if(nextMessage.getMessageSender().equals(userToSearchWith) ||
                    nextMessage.getRecipients().contains(userToSearchWith)){
                return true;
            }
        }
        return false;
    }

    public Message next(){
        while(iterator.hasNext()){
            Message nextMessage = iterator.next();
            if(nextMessage.getMessageSender().equals(userToSearchWith) ||
                    nextMessage.getRecipients().contains(userToSearchWith)){
                return nextMessage;
            }
        }
        return null;
    }
}

public class Main {
    public static void  main(String[] args){
        ChatServer chatServer = new ChatServer();

        User john = new User("John", chatServer);
        User bob = new User("Bob", chatServer);
        User kate = new User("Kate", chatServer);


        chatServer.registeruser(john);
        chatServer.registeruser(bob);
        chatServer.registeruser(kate);




        john.sendMessageToServer(List.of("Bob"), "This is the first message to Bob from John");
        bob.sendMessageToServer(List.of("Kevin"), "This is the first message to Kevin from Bob");
        john.sendMessageToServer(List.of("Kate"), "This is the second message to Kate from John");
        john.sendMessageToServer(List.of("Kate"), "Hello Kate, this is John");


        john.undoMessage();




        System.out.println("ChatHistory");
        john.viewChatHistory();
        System.out.println("Iterating over messages");
        Iterator<Message> iterateJohnMessages = john.iterator("Kate");
        while(iterateJohnMessages.hasNext()){
            Message message = iterateJohnMessages.next();
            System.out.println(message.getMessageSender() + " to " + message.getRecipients() + "> Message Content: " + message.getMessageContent());
        }


    }
}
