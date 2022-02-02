 try
        {
            
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
                            DB database = mongoClient.getDB( "sofine" );
                            System.out.println("Connect to database successfully");
                            DBCollection coll;
                            coll=database.getCollection("info");
                            System.out.println("collection selected successfully!!!");
                            
        BasicDBObject fields= new BasicDBObject();
        
        BasicDBObject where= new BasicDBObject();
        
        
        fields.put("Name",1);
        fields.put("Mob",1);
        fields.put("Add",1);
        fields.put("_id",0);
        
        where.put("Mob",jTextField2.getText());
        //where.put("Add",jTextField3.getText());
        
        DBCursor mydoc=coll.find(where,fields);
        while(mydoc.hasNext())
        {
            DBObject m=mydoc.next();
            //String value1=m.get("id").toString();
            //jTextField4.setText(value1);
            
            String value1=m.get("Name").toString();
            jTextField1.setText(value1);
            
             String value2=m.get("Mob").toString();
            jTextField2.setText(value2);
            
            String value3=m.get("Add").toString();
            jTextField3.setText(value3);
            
        }
        }
        catch(Exception ex)
                        {
                        JOptionPane.showMessageDialog(null,"Exception occured :"+ex);
                                
                        }
