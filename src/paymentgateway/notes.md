- Payment gateway acts as a mediator between user and financial institutions and help transfer money.
- Peer to Peer : User 1 makes payment to User 2
- Peer to merchant : User makes a payment to e-commerce site.


Requirement:
- User can be added/updated/deleted
- User can add/update/delete instrument(banks/cards)
- Make payment from u1 to u2
    - Search user to whom you want to pay.
    - Select amount and instrument.
    - Pass information to processor
- Notifications for crud on user/instrument, debit action, credit action etc.
- User can see transaction history.


Entities:
- User
- Instrument
- Processor
- Transaction
- Notification
- User controller
- Instrument Service
- Transaction Service
- Notification service


Flow:
- u1 is added, id is returned
- u2 is added, id is returned
- u1 calls add bank, and adds it for this user
- u2 calls add bank, and adds it for this user
- u1 wants to make payment to u2 of 10 rs
    - u1 will search u2 id
    - u1 will select its instrument by fetching it from instrument service
    - goes to transaction service to make payment
        - TS will call the IS to fetch instrument(default) details of u2
        - Both the u1/u2 details are validated
        - Passes all the details to processor
        - Processor reverts back to transaction if success or not
        - Transaction based on the response triggers notification accordingly.



Follow up question can come like:
1. Payment processing can take up to 3-5 days.
    We can make use of ASYNC operation.
        i) We will invoke Processor to validate, }
            1. if U1 has sufficient money to fund this txn.
            2. If U2 instrument is valid.
        ii) Then we can save the transaction in PENDING.
            1. We will invoke the process in ASYNC and complete the txn in PENDING state.
            2. Once Process Invoke our TXN Service and we will update the txn either SUCCESS or
            FAILURE.
