--------------------------------------------------------
--  Fichier créé - jeudi-août-22-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ARTICLE
--------------------------------------------------------

   CREATE SEQUENCE  "SYLVAIN3"."SEQ_ARTICLE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 291 CACHE 10 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_COMMANDE
--------------------------------------------------------

   CREATE SEQUENCE  "SYLVAIN3"."SEQ_COMMANDE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 231 CACHE 10 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_UTILISATEUR
--------------------------------------------------------

   CREATE SEQUENCE  "SYLVAIN3"."SEQ_UTILISATEUR"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 271 CACHE 10 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ARTICLE
--------------------------------------------------------

  CREATE TABLE "SYLVAIN3"."ARTICLE" 
   (	"ID_ARTICLE" NUMBER, 
	"LIBELLE" VARCHAR2(50 BYTE), 
	"PRIX" NUMBER, 
	"DESCRIPTION_ARTICLE" VARCHAR2(256 BYTE), 
	"NOMIMAGE" VARCHAR2(50 BYTE), 
	"ID_UTILISATEUR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table COMMANDE
--------------------------------------------------------

  CREATE TABLE "SYLVAIN3"."COMMANDE" 
   (	"ID_COMMANDE" NUMBER, 
	"DATECOMMANDE" DATE, 
	"ETAT" VARCHAR2(20 BYTE), 
	"ID_UTILISATEUR" NUMBER, 
	"PRIXTOTALE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LIGNE_COMMANDE
--------------------------------------------------------

  CREATE TABLE "SYLVAIN3"."LIGNE_COMMANDE" 
   (	"ID_COMMANDE" NUMBER, 
	"ID_ARTICLE" NUMBER, 
	"QUANTITE" NUMBER, 
	"ETAT_ARTICLEVENDEUR" VARCHAR2(20 BYTE) DEFAULT 'NON TRAITEE'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table UTILISATEUR
--------------------------------------------------------

  CREATE TABLE "SYLVAIN3"."UTILISATEUR" 
   (	"ID_UTILISATEUR" NUMBER, 
	"NOM" VARCHAR2(50 BYTE), 
	"PRENOM" VARCHAR2(50 BYTE), 
	"DATENAISSANCE" DATE, 
	"TELEPHONE" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PASS" VARCHAR2(20 BYTE), 
	"TYPE_UTILISATEUR" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYLVAIN3.ARTICLE
SET DEFINE OFF;
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('271','PC','5000','pc gamer','/PC1016.jpg','255');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('285','collins','23,3','jjhvjhvj','/hvhjjv.jpg','172');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('282','tytft','153','nkkj','/vghvgh.jpg','172');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('269','PC','1000','Ce PC','/PC10000018.jpg','172');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('270','PC Gamer','1500','Ce PC Gamer','/PC10000019.jpg','172');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('283','maison','13,3','jnkjnk','sds','172');
Insert into SYLVAIN3.ARTICLE (ID_ARTICLE,LIBELLE,PRIX,DESCRIPTION_ARTICLE,NOMIMAGE,ID_UTILISATEUR) values ('284','maison','13,6','nklnkjnnj','jkjk','172');
REM INSERTING into SYLVAIN3.COMMANDE
SET DEFINE OFF;
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('209',to_date('18/01/19','DD/MM/RR'),'NON TRAITEE','253',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('207',to_date('18/01/19','DD/MM/RR'),'TRAITEE','219',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('208',to_date('18/01/19','DD/MM/RR'),'TRAITEE','219',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('210',to_date('18/01/19','DD/MM/RR'),'NON TRAITEE','253',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('211',to_date('18/01/19','DD/MM/RR'),'NON TRAITEE','253',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('212',to_date('18/01/19','DD/MM/RR'),'NON TRAITEE','253',null);
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('223',to_date('20/08/19','DD/MM/RR'),'NON TRAITEE','253','5153');
Insert into SYLVAIN3.COMMANDE (ID_COMMANDE,DATECOMMANDE,ETAT,ID_UTILISATEUR,PRIXTOTALE) values ('224',to_date('22/08/19','DD/MM/RR'),'NON TRAITEE','229','306');
REM INSERTING into SYLVAIN3.LIGNE_COMMANDE
SET DEFINE OFF;
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('207','269','1','TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('208','270','1','TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('208','269','4','TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('210','270','1','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('211','270','5','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('212','270','10','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('212','271','1','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('223','282','1','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('223','271','1','NON TRAITEE');
Insert into SYLVAIN3.LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE,ETAT_ARTICLEVENDEUR) values ('224','282','2','NON TRAITEE');
REM INSERTING into SYLVAIN3.UTILISATEUR
SET DEFINE OFF;
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('174','test','testaaa',to_date('15/03/95','DD/MM/RR'),'+32474747474','test@test.com','test','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('208','grgr','grgr',to_date('03/01/94','DD/MM/RR'),'+324747474','r@r.com','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('205','r','r',to_date('18/02/94','DD/MM/RR'),'+32474747474','rt@rty.com','rt','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('251','collins','aged',to_date('22/11/69','DD/MM/RR'),'+65526565656','collins@hotmail.com','collins','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('211','test','test',to_date('18/02/94','DD/MM/RR'),'+32474747474','test@test.be','test','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('209','grgr','grgr',to_date('18/02/94','DD/MM/RR'),'+324747474','r@t.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('212','testaaaa','test',to_date('03/01/95','DD/MM/RR'),'+33474263096','dav-6032@hotmail.com','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('213','testaaaa','test',to_date('03/01/95','DD/MM/RR'),'+33474263096','dav-32032@hotmail.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('214','a','a',to_date('03/01/95','DD/MM/RR'),'+33474263096','a@b.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('215','a','a',to_date('03/01/95','DD/MM/RR'),'+33474263096','a@a.be','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('216','a','a',to_date('03/01/95','DD/MM/RR'),'+33474263096','a@a.fr','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('217','a','a',to_date('18/02/94','DD/MM/RR'),'+324747474','duhantsylvain@gmail.de','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('218','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','rt@rtu.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('219','Wolfs','David',to_date('18/02/94','DD/MM/RR'),'+32474747474','david.wolfs@condorcet.be','test','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('220','esresr','seres',to_date('18/02/94','DD/MM/RR'),'+32474747474','t@t.com','t','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('221','esresr','seres',to_date('18/02/94','DD/MM/RR'),'+32474747474','y@y.com','y','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('222','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','a@c.com','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('223','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','a@d.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('240','vdv','a',to_date('21/05/69','DD/MM/RR'),'071235689','anne@vdv.be','1234','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('252','JKJjjjjj','klk',to_date('22/11/69','DD/MM/RR'),'0458965447855','ol@lol.com','12345678962','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('226','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','b@nb.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('227','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','b@naaaaab.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('228','a','a',to_date('03/01/94','DD/MM/RR'),'+32474747474','fff@fff.com','a','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('229','azertyaaa','azerty',to_date('18/02/94','DD/MM/RR'),'+32474747474','azerty@azerty.com','azerty','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('230','qsqsfesf','ggvsgrd',to_date('18/02/94','DD/MM/RR'),'+32474747474','vdsgveds@gesg.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('231','qsqsfesf','ggvsgrd',to_date('18/02/94','DD/MM/RR'),'+32474747474','vdsgveds@gesg.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('253','Test','tes',to_date('30/12/97','DD/MM/RR'),'0123456789','sylvain@duhant.be','test','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('254','Test01','Hey',to_date('10/10/10','DD/MM/RR'),'0123456789','tet@mail.be','pass','Client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('255','testexamen','testexamen',to_date('18/02/94','DD/MM/RR'),'+32474747474','testexamen@testexamen.com','testexamen','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('261','collins','agedo',to_date('22/11/95','DD/MM/RR'),'048965323','collinsmen@hotmail.com','collins','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('237','testpost','testpost',to_date('30/12/20','DD/MM/RR'),'+32474757575','testpost@ttestpost.com','testpost','client');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('238','testpostman2','testpostman2',to_date('15/01/19','DD/MM/RR'),'+32474747474','j@j.com','j','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('172','a','a',to_date('18/02/94','DD/MM/RR'),'+32474747474','a@a.com','a','vendeur');
Insert into SYLVAIN3.UTILISATEUR (ID_UTILISATEUR,NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR) values ('173','Duhant','Sylvain',to_date('30/12/97','DD/MM/RR'),'0987654321','duhantsylvain@gmail.com','pommedeterre','client');
--------------------------------------------------------
--  DDL for Index PK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYLVAIN3"."PK2" ON "SYLVAIN3"."COMMANDE" ("ID_COMMANDE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK4
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYLVAIN3"."PK4" ON "SYLVAIN3"."LIGNE_COMMANDE" ("ID_COMMANDE", "ID_ARTICLE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK3
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYLVAIN3"."PK3" ON "SYLVAIN3"."ARTICLE" ("ID_ARTICLE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYLVAIN3"."PK1" ON "SYLVAIN3"."UTILISATEUR" ("ID_UTILISATEUR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger TRIG_ETAT_COMMANDE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYLVAIN3"."TRIG_ETAT_COMMANDE" before insert on commande for each row
begin
  :new.etat := 'NON TRAITEE';
end;

/
ALTER TRIGGER "SYLVAIN3"."TRIG_ETAT_COMMANDE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIGGER_ARTICLE_ID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYLVAIN3"."TRIGGER_ARTICLE_ID" 
BEFORE INSERT
ON ARTICLE
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
  if(:new.ID_ARTICLE is null) then
  SELECT seq_article.nextval
  INTO :new.ID_ARTICLE
  FROM dual;
  end if;
END;

/
ALTER TRIGGER "SYLVAIN3"."TRIGGER_ARTICLE_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIGGER_COMMANDE_ID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYLVAIN3"."TRIGGER_COMMANDE_ID" 
BEFORE INSERT
ON COMMANDE
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
  if(:new.ID_COMMANDE is null) then
  SELECT seq_commande.nextval
  INTO :new.ID_COMMANDE
  FROM dual;
  end if;
END;

/
ALTER TRIGGER "SYLVAIN3"."TRIGGER_COMMANDE_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIGGER_UTILISATEUR_ID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYLVAIN3"."TRIGGER_UTILISATEUR_ID" 
BEFORE INSERT
ON UTILISATEUR
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
  if(:new.ID_UTILISATEUR is null) then
  SELECT seq_utilisateur.nextval
  INTO :new.ID_UTILISATEUR
  FROM dual;
  end if;
END;

/
ALTER TRIGGER "SYLVAIN3"."TRIGGER_UTILISATEUR_ID" ENABLE;
--------------------------------------------------------
--  DDL for Procedure FINDITEMSVENDU
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SYLVAIN3"."FINDITEMSVENDU" (
        id_vendeur in Article.id_utilisateur%type     )is
    begin
        OPEN cur_art for
        select * from article art inner join ligne_commande lc 
        on lc.id_article = art.ID_ARTICLE 
        where art.ID_UTILISATEUR =  id_vendeur;
    end findItemsVendu;


/
--------------------------------------------------------
--  DDL for Package PKG_ARTICLE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SYLVAIN3"."PKG_ARTICLE" 
AS
TYPE cur_article IS REF CURSOR;
 PROCEDURE createArticle ( 
    libelle_article IN Article.libelle%TYPE,
    prix_article in Article.prix%TYPE,
    description_art in Article.description_article%type,
    nom_image in article.nomimage%type,
    id_vendeur in article.id_utilisateur%type
    );

	/* Permet de trouver un article à partir de son id */
  PROCEDURE findById(
    id_art in Article.id_article%type,
    cur_art OUT cur_article
  );

  /* Permet de trouver tous les articles */
  PROCEDURE findAll(cur_art OUT cur_article);

  /* Permet de supprimer un article à partir de son id */
  PROCEDURE deleteArticle(id_art in article.id_article%type);

  /* Permet de mettre à jour un article */
    PROCEDURE updateArticle(
        id_art in Article.id_article%type,
        libelle_article IN Article.libelle%TYPE,
        prix_article in Article.prix%TYPE,
        description_art in Article.description_article%type
    );

    /* Permet de trouver tous les articles par un vendeur */
     PROCEDURE findItemsVendor(
        id_uti in Article.id_utilisateur%type,
        cur_art OUT cur_article
    );

    /* Permet de trouver tous les articles par un vendeur se trouvant dans ligne_commande */
     PROCEDURE findItemsVendu(
        id_vendeur in Article.id_utilisateur%type,
        cur_art OUT cur_article
    );

/* Permet de trouver tous les articles par une commande */
     PROCEDURE findItemsCommande(
        id_com in Commande.ID_COMMANDE%type,
        cur_art OUT cur_article
    );

END PKG_Article;

/
--------------------------------------------------------
--  DDL for Package PKG_COMMANDE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SYLVAIN3"."PKG_COMMANDE" 
AS
TYPE cur_commande IS REF CURSOR;
PROCEDURE createCommande ( 
    datecommande_commande in COMMANDE.DATECOMMANDE%type,
    id_uti in commande.id_utilisateur%type,    
    PRIXTOTALE in Commande.PRIXTOTALE%type
);

PROCEDURE createLigneCommande ( 
    id_com in COMMANDE.ID_COMMANDE%type,
    id_art in ARTICLE.ID_ARTICLE%TYPE,
    quant in LIGNE_COMMANDE.QUANTITE%TYPE
);

/* Permet de mettre à jour l'état de l'article par le vendeur' */
PROCEDURE updateEtatArticle ( 
    id_art in ligne_commande.id_article%type,
    etat_article in ligne_commande.ETAT_ARTICLEVENDEUR%TYPE,
    id_comm in ligne_commande.id_commande%type
);

/* Permet de trouver une commande à partir de son id */
 PROCEDURE findById(
    id_com in Commande.ID_COMMANDE%type,
    cur_com OUT cur_commande
  );

  /* Permet de trouver une commande à partir d'un id utilisateur */
  PROCEDURE findCommandeUtilisateur(
    id_uti in Commande.ID_UTILISATEUR%type,
    cur_com OUT cur_commande
  );

   /* Permet de trouver toutes les commandes avec la table ligne_commande */
  PROCEDURE findAll(
    cur_com OUT cur_commande
  );

   /* Permet de trouver toutes les commandes sans la table ligne_commande */
  PROCEDURE findAllJustCommande(
    cur_com OUT cur_commande
  );
END PKG_COMMANDE;

/
--------------------------------------------------------
--  DDL for Package PKG_UTILISATEUR
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SYLVAIN3"."PKG_UTILISATEUR" 
AS

 
/******************************************************************************
   NOM:            PKG_NOM
   DESCRIPTION:    Package contenant les fonctions liées à l'utilisateur

******************************************************************************/
/*  VARIABLES GLOBALES */
TYPE cur_login IS REF CURSOR;
TYPE cur_utilisateur IS REF CURSOR;

/* DETAILS PROCEDURE 
	Procédure permettant de créer un utilisateur
*/
PROCEDURE createUtilisateur ( 
    nom_utilisateur IN Utilisateur.nom%TYPE, 
    prenom_utilisateur in Utilisateur.PRENOM%TYPE,
    dateNaissance_utilisateur in Utilisateur.DATENAISSANCE%type,
    telephone_utilisateur in Utilisateur.telephone%type,
    email_utilisateur in Utilisateur.EMAIL%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE,
    type_uti in Utilisateur.type_utilisateur%type
    );
-- mise à jour d'un utilisateur
PROCEDURE updateUtilisateur (
    id_user in Utilisateur.ID_Utilisateur%TYPE,
    nom_utilisateur IN Utilisateur.nom%TYPE, 
    prenom_utilisateur in Utilisateur.PRENOM%TYPE,
    dateNaissance_utilisateur in Utilisateur.DATENAISSANCE%type,
    telephone_utilisateur in Utilisateur.telephone%type,
    email_utilisateur in Utilisateur.EMAIL%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE
    );

	/* Verifie si le login de l'utilisateur est correct */
PROCEDURE loginUtilisateur(
    email_utilisateur in Utilisateur.email%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE,
    p_ref OUT cur_login
  );

  /* Permet de trouver un utilisateur à partir de son id */
PROCEDURE findById(
id_uti in Utilisateur.id_utilisateur%type,
cur_uti OUT cur_utilisateur
);

 /* Permet de trouver un utilsiateur à partir de son id */
PROCEDURE findIDUtilisateur(
    id_uti in Utilisateur.id_utilisateur%TYPE,
    p_ref OUT cur_login
  );


   /* Permet de trouver tous les utilisateurs */
PROCEDURE findAll(cur_uti OUT cur_utilisateur);

  /* Permet de trouver tous les clients */
PROCEDURE findAllClient(cur_uti OUT cur_utilisateur);

  /* Permet de trouver tous les vendeurs */
PROCEDURE findAllVendeur(cur_uti OUT cur_utilisateur);

ex_violationContraite EXCEPTION;
PRAGMA EXCEPTION_INIT(ex_violationContraite,-2291);

END PKG_UTILISATEUR;

/
--------------------------------------------------------
--  DDL for Package Body PKG_ARTICLE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SYLVAIN3"."PKG_ARTICLE" 
AS
 PROCEDURE createArticle ( 
    libelle_article IN Article.libelle%TYPE,
    prix_article in Article.prix%TYPE,
    description_art in Article.description_article%type,
    nom_image in article.nomimage%type,
    id_vendeur in article.id_utilisateur%type
    )
  IS
  /* DECLARATION VARIABLES */
  BEGIN
     insert into Article (libelle,prix,description_article,nomimage,id_utilisateur)
        values(libelle_article,prix_article,description_art,nom_image,id_vendeur);
        commit;
  END createArticle;

  PROCEDURE findById(
    id_art in Article.id_article%type,
    cur_art OUT cur_article
  )
is
begin
    OPEN cur_art for
       SELECT *
        FROM Article
        where id_article=id_art;
end findById;

  PROCEDURE findAll(
    cur_art OUT cur_article
  )
  is
begin
    OPEN cur_art for
       SELECT * FROM Article;
end findAll;

PROCEDURE deleteArticle(id_art in article.id_article%type)
  is
  begin
  delete FROM article WHERE id_article = id_art;
  end deleteArticle;

     PROCEDURE updateArticle(
        id_art in Article.id_article%type,
        libelle_article IN Article.libelle%TYPE,
        prix_article in Article.prix%TYPE,
        description_art in Article.description_article%type
  )is
  begin
    update Article set
        libelle = libelle_article,
        prix = prix_article,
        description_article = description_art
        where id_article = id_art;
        commit;
  end updateArticle;

 PROCEDURE findItemsVendor(
        id_uti in Article.id_utilisateur%type,
        cur_art OUT cur_article
    )is
    begin
        OPEN cur_art for
        SELECT * FROM Article 
        where Article.id_utilisateur = id_uti;
    end findItemsVendor;

   PROCEDURE findItemsVendu(
        id_vendeur in Article.id_utilisateur%type,
        cur_art OUT cur_article
    )is
    begin
        OPEN cur_art for
        select lc.ID_COMMANDE, art.ID_ARTICLE, LIBELLE, PRIX, DESCRIPTION_ARTICLE, NOMIMAGE,ETAT_ARTICLEVENDEUR
        from article art inner join ligne_commande lc 
        on lc.id_article = art.ID_ARTICLE 
        where art.ID_UTILISATEUR =  id_vendeur;
    end findItemsVendu;

    PROCEDURE findItemsCommande(
        id_com in Commande.ID_COMMANDE%type,
        cur_art OUT cur_article
    )is
    begin
        OPEN cur_art for
       SELECT *
        FROM Article
		 INNER JOIN Ligne_Commande ON Ligne_Commande.ID_ARTICLE = ARTICLE.ID_ARTICLE
         INNER JOIN COMMANDE ON Ligne_Commande.ID_COMMANDE = COMMANDE.ID_COMMANDE
        where COMMANDE.ID_COMMANDE = id_com;
    end findItemsCommande;

END PKG_Article;

/
--------------------------------------------------------
--  DDL for Package Body PKG_COMMANDE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SYLVAIN3"."PKG_COMMANDE" 
AS
PROCEDURE createCommande ( 
    datecommande_commande in COMMANDE.DATECOMMANDE%type,
    id_uti in commande.id_utilisateur%type,
        PRIXTOTALE in Commande.PRIXTOTALE%type
)
  IS
  /* DECLARATION VARIABLES */
  BEGIN
     insert into commande (DATECOMMANDE,ID_UTILISATEUR,PRIXTOTALE)
        values(datecommande_commande,id_uti,PRIXTOTALE);
        commit;
  END createCommande;

PROCEDURE createLigneCommande ( 
    id_com in COMMANDE.ID_COMMANDE%type,
    id_art in ARTICLE.ID_ARTICLE%TYPE,
    quant in LIGNE_COMMANDE.QUANTITE%TYPE
)
  IS
  /* DECLARATION VARIABLES */
  BEGIN
     insert into LIGNE_COMMANDE (ID_COMMANDE,ID_ARTICLE,QUANTITE)
        values(id_com,id_art,quant);
        commit;
  END createLigneCommande;

--PROCEDURE updateEtatArticle ( 
--    id_art in ligne_commande.id_article%type,
--    etat_article in ligne_commande.ETAT_ARTICLEVENDEUR%TYPE,
--    id_comm in ligne_commande.id_commande%type
--)
--IS
--cursor cur (id_com integer := id_comm) is select * from ligne_commande where id_commande = id_com;
--isvalid integer;
--BEGIN
--    UPDATE LIGNE_COMMANDE SET ETAT_ARTICLEVENDEUR = etat_article WHERE id_article = id_art AND id_commande = id_comm;
--    isvalid := 1;
--    FOR u IN cur LOOP
--      IF u.etat_articlevendeur = 'TRAITEE' THEN
--        isvalid := -1;
--      END IF;
--    END LOOP;
--    IF isvalid = 1 THEN
--     update commande set etat = 'TRAITEE' where id_commande = id_comm;
--    END IF;
--END updateEtatArticle;

PROCEDURE updateEtatArticle ( 
    id_art in ligne_commande.id_article%type,
    etat_article in ligne_commande.ETAT_ARTICLEVENDEUR%TYPE,
    id_comm in ligne_commande.id_commande%type
)
IS
cursor cur (id_com integer := id_comm) is select * from ligne_commande where id_commande = id_com;
i integer := 0;
j integer := 0;
BEGIN
    UPDATE LIGNE_COMMANDE SET ETAT_ARTICLEVENDEUR = etat_article WHERE id_article = id_art AND id_commande = id_comm;
    FOR u IN cur LOOP
      IF u.ETAT_ARTICLEVENDEUR = 'TRAITEE' THEN
        i := i + 1;
      END IF;
        j := cur%rowcount;
    END LOOP;
    IF i = j THEN
     update commande set etat = 'TRAITEE' where id_commande = id_comm;
    END IF;
END updateEtatArticle;


 PROCEDURE findById(
    id_com in Commande.ID_COMMANDE%type,
    cur_com OUT cur_commande
  )
is
begin
    OPEN cur_com for
     SELECT *
        FROM COMMANDE
        INNER JOIN Ligne_Commande ON Ligne_Commande.ID_COMMANDE = COMMANDE.ID_COMMANDE
         INNER JOIN ARTICLE ON Ligne_Commande.ID_ARTICLE = ARTICLE.ID_ARTICLE
		INNER JOIN UTILISATEUR ON Commande.ID_UTILISATEUR = UTILISATEUR.ID_UTILISATEUR
        where COMMANDE.ID_COMMANDE=id_com;
end findById;

  PROCEDURE findCommandeUtilisateur(
    id_uti in Commande.ID_UTILISATEUR%type,
    cur_com OUT cur_commande
  )
  is
  begin
    OPEN cur_com for
      SELECT *
        FROM Commande
		INNER JOIN UTILISATEUR ON Commande.ID_UTILISATEUR = UTILISATEUR.ID_UTILISATEUR
        where COMMANDE.ID_UTILISATEUR = id_uti;
  end findCommandeUtilisateur;

   PROCEDURE findAll(
    cur_com OUT cur_commande
  )
  is
  begin
    OPEN cur_com for
      SELECT *
        FROM Commande 
        INNER JOIN Ligne_Commande ON Ligne_Commande.ID_COMMANDE = COMMANDE.ID_COMMANDE;
  end findAll;

   PROCEDURE findAllJustCommande(
    cur_com OUT cur_commande
  )
  is
  begin
    OPEN cur_com for
      SELECT *
        FROM Commande;
  end findAllJustCommande;
END PKG_COMMANDE;

/
--------------------------------------------------------
--  DDL for Package Body PKG_UTILISATEUR
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SYLVAIN3"."PKG_UTILISATEUR" 
AS
 PROCEDURE createUtilisateur ( 
    nom_utilisateur IN Utilisateur.nom%TYPE, 
    prenom_utilisateur in Utilisateur.PRENOM%TYPE,
    datenaissance_utilisateur in Utilisateur.datenaissance%type,
    telephone_utilisateur in Utilisateur.telephone%type,
    email_utilisateur in Utilisateur.EMAIL%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE,
    type_uti in Utilisateur.type_utilisateur%type
    )
  IS
  /* DECLARATION VARIABLES */
  BEGIN
     insert into utilisateur (NOM,PRENOM,DATENAISSANCE,TELEPHONE,EMAIL,PASS,TYPE_UTILISATEUR)
        values(nom_utilisateur,prenom_utilisateur,datenaissance_utilisateur,telephone_utilisateur,email_utilisateur,pass_utilisateur,type_uti);
        commit;

  END createUtilisateur;

--Mise à jour utilisateur
PROCEDURE updateUtilisateur(
    id_user in Utilisateur.ID_Utilisateur%TYPE,
    nom_utilisateur IN Utilisateur.nom%TYPE, 
    prenom_utilisateur in Utilisateur.PRENOM%TYPE,
    dateNaissance_utilisateur in Utilisateur.DATENAISSANCE%type,
    telephone_utilisateur in Utilisateur.telephone%type,
    email_utilisateur in Utilisateur.EMAIL%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE
)
IS

BEGIN
  update utilisateur set id_utilisateur = id_user, nom=nom_utilisateur, prenom = prenom_utilisateur,dateNaissance = 
  dateNaissance_utilisateur, telephone = telephone_utilisateur, email = email_utilisateur, pass = pass_utilisateur where id_utilisateur = id_user;
  commit;
END updateUtilisateur;

PROCEDURE loginUtilisateur(
    email_utilisateur in Utilisateur.email%TYPE,
    pass_utilisateur in Utilisateur.pass%TYPE,
    p_ref OUT cur_login
  )
is 

begin
  OPEN p_ref for
       SELECT *
        FROM UTILISATEUR
        where email=email_utilisateur and pass=pass_utilisateur;
end loginUtilisateur;

 PROCEDURE findById(
    id_uti in Utilisateur.id_utilisateur%type,
    cur_uti OUT cur_utilisateur
  )
is
begin
    OPEN cur_uti for
       SELECT *
        FROM UTILISATEUR
        where id_utilisateur=id_uti;
end findById;

PROCEDURE findIDUtilisateur(
    id_uti in Utilisateur.id_utilisateur%TYPE,
    p_ref OUT cur_login
  )
is 

begin
  OPEN p_ref for
       SELECT *
        FROM UTILISATEUR
        where id_utilisateur = id_uti;
  Exception 
    when NO_DATA_FOUND then
      dbms_output.put_line('Impossible de trouver l utilisateur');
end findIDUtilisateur;

PROCEDURE findAll(
    cur_uti OUT cur_utilisateur
  )
  is
begin
    OPEN cur_uti for
       SELECT * FROM UTILISATEUR;
end findAll;

PROCEDURE findAllClient(
    cur_uti OUT cur_utilisateur
  )
  is
begin
    OPEN cur_uti for
       SELECT * FROM UTILISATEUR WHERE TYPE_UTILISATEUR = 'client';
end findAllClient;

PROCEDURE findAllVendeur(
    cur_uti OUT cur_utilisateur
  )
  is
begin
    OPEN cur_uti for
       SELECT * FROM UTILISATEUR WHERE TYPE_UTILISATEUR = 'vendeur';
end findAllVendeur;

END PKG_UTILISATEUR;


/
--------------------------------------------------------
--  Constraints for Table ARTICLE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."ARTICLE" ADD CONSTRAINT "PK3" PRIMARY KEY ("ID_ARTICLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYLVAIN3"."ARTICLE" MODIFY ("ID_ARTICLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table UTILISATEUR
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."UTILISATEUR" ADD CONSTRAINT "PK1" PRIMARY KEY ("ID_UTILISATEUR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYLVAIN3"."UTILISATEUR" MODIFY ("ID_UTILISATEUR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMMANDE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."COMMANDE" ADD CONSTRAINT "PK2" PRIMARY KEY ("ID_COMMANDE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYLVAIN3"."COMMANDE" MODIFY ("ID_COMMANDE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LIGNE_COMMANDE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."LIGNE_COMMANDE" ADD CONSTRAINT "PK4" PRIMARY KEY ("ID_COMMANDE", "ID_ARTICLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYLVAIN3"."LIGNE_COMMANDE" MODIFY ("ID_ARTICLE" NOT NULL ENABLE);
  ALTER TABLE "SYLVAIN3"."LIGNE_COMMANDE" MODIFY ("ID_COMMANDE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ARTICLE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."ARTICLE" ADD CONSTRAINT "ARTICLE_FOREIGN_KEY" FOREIGN KEY ("ID_UTILISATEUR")
	  REFERENCES "SYLVAIN3"."UTILISATEUR" ("ID_UTILISATEUR") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMMANDE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."COMMANDE" ADD CONSTRAINT "COMMANDE_FOREIGN_KEY" FOREIGN KEY ("ID_UTILISATEUR")
	  REFERENCES "SYLVAIN3"."UTILISATEUR" ("ID_UTILISATEUR") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LIGNE_COMMANDE
--------------------------------------------------------

  ALTER TABLE "SYLVAIN3"."LIGNE_COMMANDE" ADD CONSTRAINT "LIGNE_COMMANDE_FOREIGN_KEY1" FOREIGN KEY ("ID_COMMANDE")
	  REFERENCES "SYLVAIN3"."COMMANDE" ("ID_COMMANDE") ON DELETE CASCADE ENABLE;
  ALTER TABLE "SYLVAIN3"."LIGNE_COMMANDE" ADD CONSTRAINT "LIGNE_COMMANDE_FOREIGN_KEY2" FOREIGN KEY ("ID_ARTICLE")
	  REFERENCES "SYLVAIN3"."ARTICLE" ("ID_ARTICLE") ON DELETE CASCADE ENABLE;
