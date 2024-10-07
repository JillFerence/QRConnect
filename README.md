# QRConnect - QR Code Event Check-In System

## Description
QRConnect is an Android application built with Java, designed to streamline event management by enabling attendees to check in using QR codes on their mobile devices. With QRConnect, organizers can effortlessly track attendance, manage event details, and send notifications in real time. 

### Technologies Used:
- **Java**: The primary language used for developing the Android application.
- **Firebase**: For real-time database management and notifications.
- **Camera X, ZXing, ML Kit**: For enabling QR code scanning functionality.

### Features:
- **QR Code Scanning**: Attendees can easily check in by scanning event-specific QR codes.
- **Firebase Integration**: Utilizes Firebase for storing event details, attendee lists, and real-time check-in status updates.
- **Multi-User Interaction**: Distinguishes between organizers and attendees with different app roles and permissions.
- **Geolocation Verification**: Verifies attendee presence at the event location using geolocation.
- **Image Upload**: Allows organizers to upload event posters and attendees to upload profile pictures for personalization.

### Scenario:
John, an event organizer, utilizes QRConnect for his upcoming tech conference. He generates a unique QR code for the event and attendees sign up indicating their attendance. As attendees arrive, they scan the QR code for seamless check-ins, updating John's dashboard in real time. John can also send push notifications to all attendees through the app.

**User Roles:**
- **Organizer**: Responsible for event organization and control within the app.
- **Attendee**: Individuals attending the event.
- **Administrator**: Manages the infrastructure of the application.

### User Stories:
**Organizer**
- **US 01.01.01:** Create a new event and generate a unique QR code for attendee check-ins.
- **US 01.02.01:** View the list of attendees who have checked in to the event.
- **US 01.03.01:** Send notifications to all attendees through the app.
- **US 01.04.01:** Upload an event poster for visual information.
- **US 01.05.01:** Track real-time attendance and receive alerts.
- **US 01.06.01:** Share a generator QR code image with other apps.
- **US 01.07.01:** Generate a unique promotion QR code for events.
- **US 01.08.01:** View attendee check-in locations on a map.
- **US 01.09.01:** Track attendee check-in frequency.
- **US 01.10.01:** View the list of attendees signed up for an event.
- **US 01.11.01:** Optionally limit the number of attendees for an event.

**Attendee**
- **US 02.01.01:** Quickly check into an event by scanning the QR code.
- **US 02.02.01:** Upload a profile picture for personalization.
- **US 02.02.02:** Remove profile pictures if necessary.
- **US 02.02.03:** Update profile information.
- **US 02.03.01:** Receive push notifications from organizers.
- **US 02.04.01:** View event details and announcements.
- **US 02.05.01:** Automatically generate a profile picture from the profile name.
- **US 02.06.01:** Access the app without login credentials.
- **US 02.07.01:** Sign up to attend an event.
- **US 02.08.01:** Browse event posters and details.
- **US 02.09.01:** View signed-up events.

**Organizer & Attendee**
- **US 03.02.01:** Enable or disable geolocation tracking for event verification.

**Administrator**
- **US 04.01.01:** Remove events.
- **US 04.02.01:** Remove profiles.
- **US 04.03.01:** Remove images.
- **US 04.04.01:** Browse events.
- **US 04.05.01:** Browse profiles.
- **US 04.06.01:** Browse images.

## Setup & Usage

## Credits
- **Developer**: Jill Ference  
  [GitHub Profile](https://github.com/jillference) | [LinkedIn](https://linkedin.com/in/jillference)
- **Developer**: Luwei-Lin  
  [GitHub Profile](https://github.com/Luwei-Lin)
- **Developer**: Billyisher  
  [GitHub Profile](https://github.com/Billyisher))
- **Developer**: TanmayJL  
  [GitHub Profile](https://github.com/TanmayJL)
- **Developer**: wchorkaw  
  [GitHub Profile](https://github.com/wchorkaw)
- **Developer**: kevinfrito  
  [GitHub Profile](https://github.com/kevinfrito)

## License
This project is licensed under the [MIT License](https://github.com/JillFerence/QRConnect/tree/main?tab=MIT-1-ov-file).
