package com.ls.businessMod.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ls.dataMod.model.CustomUserDetails;
import com.ls.dataMod.model.user.User;
import com.ls.dataMod.repositories.UserProfileReposotory;
import com.ls.dataMod.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileReposotory userProfileRepository;

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User addUser(User user){
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//Set<UserProfile> userProfileSet = user.getUserProfiles();

		if(null == user.getId()){
			user.setId(UUID.randomUUID());
		}
		System.out.println(user.getId());
		user.setCreateDate(Instant.now());
		user.setUpdateDate(Instant.now());
		try {
			sendMail(user);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.save(user);
	}

	private void sendMail(User user) throws AddressException, MessagingException{
		setMailServerProperties();
		createEmailMessage();
		sendEmail();
	}
	
	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		emailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	}

	public void createEmailMessage() throws AddressException,
	MessagingException {
		String[] toEmails = { "ladderstoneofficial@gmail.com" };
		String emailSubject = "Java Email";
		String emailBody = "This is an email sent by JavaMail api.";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
		//emailMessage.setText(emailBody);// for a text email

	}
	
	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "ladderstoneofficial@gmail.com";//just the id alone without @gmail.com
		String fromUserEmailPassword = "ladderStone123#";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

		Optional<User> optionalUsers = userRepository.findByEmailAndPassword(email,"000");
		optionalUsers
		.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));

		return optionalUsers
				.map(CustomUserDetails::new).get();
	}

	public UserDetails loadUserByUsername(String userName, String password) throws UsernameNotFoundException {

		Optional<User> optionalUsers = userRepository.findByUserNameAndPassword(userName, password);
		optionalUsers
		.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));

		return optionalUsers
				.map(CustomUserDetails::new).get();
	}

	@Override
	public User updateUserDetails(User user) {
		/*Instant createDate = userRepository.findAllById(user.getId()).map(User::new).get().getCreateDate();
		userRepository.delete(user);
		user.setId(null);
		user.setCreateDate(createDate);
		user.setUpdateDate(Instant.now());
		return userRepository.save(user);*/
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
