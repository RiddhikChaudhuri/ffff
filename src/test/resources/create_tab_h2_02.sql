
CREATE TABLE IF NOT EXISTS `test_person` (

	person_id			BIGINT			NOT NULL,
	person_code			VARCHAR(128)		NOT NULL,
	person_name			VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS `trl_users` (

	user_id				BIGINT			NOT NULL,
	tenant_id			VARCHAR(128)		NOT NULL,
	user_name			VARCHAR(128)		NOT NULL,
	user_type			VARCHAR(64)		NOT NULL,
	primary_email			VARCHAR(256)		NOT NULL,
	ldap_reference			VARCHAR(256),
	status				VARCHAR(64)		NOT NULL,
	lc_status_chg_date		DATE			NOT NULL,
	enabled_flag			TINYINT(1)		NOT NULL,
	workflow_status			VARCHAR(64),
	wf_status_chg_date		DATE,
	created_by_id			BIGINT			NOT NULL,
	created_by			VARCHAR(128)		NOT NULL,
	creation_date			DATE			NOT NULL,
	revised_by_id			BIGINT			NOT NULL,
	revised_by			VARCHAR(128)		NOT NULL,
	revision_date			DATE			NOT NULL,
	object_version_number           VARCHAR(64)		NOT NULL

);

CREATE TABLE IF NOT EXISTS `trl_user_role_associations` (

	user_role_asscn_id		BIGINT			NOT NULL,
	tenant_id			VARCHAR(128)		NOT NULL,
	user_ref			BIGINT			NOT NULL,
	user_name			VARCHAR(64)		NOT NULL,
	role_ref			BIGINT			NOT NULL,
	role_code			VARCHAR(64)		NOT NULL,
	status				VARCHAR(64)		NOT NULL,
	lc_status_chg_date		DATE			NOT NULL,
	enabled_flag			TINYINT(1)		NOT NULL,
	workflow_status			VARCHAR(64),
	wf_status_chg_date		DATE,
	created_by_id			BIGINT			NOT NULL,
	created_by			VARCHAR(128)		NOT NULL,
	creation_date			DATE			NOT NULL,
	revised_by_id			BIGINT			NOT NULL,
	revised_by			VARCHAR(128)		NOT NULL,
	revision_date			DATE			NOT NULL,
	object_version_number           VARCHAR(64)             NOT NULL

);

CREATE TABLE IF NOT EXISTS `trl_roles` (

	role_id				BIGINT                  NOT NULL,
	tenant_id			VARCHAR(128)            NOT NULL,
	role_code			BIGINT			NOT NULL,
	role_name			VARCHAR(256)		NOT NULL,
	role_ref			BIGINT			NOT NULL,
	role_source			VARCHAR(64)		NOT NULL,
	ext_role_reference		VARCHAR(128),
	status				VARCHAR(64)		NOT NULL,
	lc_status_chg_date		DATE			NOT NULL,
	enabled_flag			TINYINT(1)		NOT NULL,
	workflow_status			VARCHAR(64),
	wf_status_chg_date		DATE,
	created_by_id			BIGINT			NOT NULL,
	created_by			VARCHAR(128)		NOT NULL,
	creation_date			DATE			NOT NULL,
	revised_by_id			BIGINT			NOT NULL,
	revised_by			VARCHAR(128)		NOT NULL,
	revision_date			DATE			NOT NULL,
	object_version_number           VARCHAR(64)		NOT NULL

);

CREATE TABLE IF NOT EXISTS `trl_role_privileges` (

	role_priv_asscn_id		BIGINT			NOT NULL,
	tenant_id			VARCHAR(128)		NOT NULL,
	parent_role_ref			BIGINT			NOT NULL,
	parent_role_code		VARCHAR(64)		NOT NULL,
	role_ref			BIGINT			NOT NULL,
	role_code			VARCHAR(64)		NOT NULL,
	object_priv_ref			BIGINT			NOT NULL,
	object_priv_code		VARCHAR(64)		NOT NULL,
	status				VARCHAR(64)		NOT NULL,
	lc_status_chg_date		DATE			NOT NULL,
	enabled_flag			TINYINT(1)		NOT NULL,
	workflow_status			VARCHAR(64),
	wf_status_chg_date		DATE,
	created_by_id			BIGINT			NOT NULL,
	created_by			VARCHAR(128)		NOT NULL,
	creation_date			DATE			NOT NULL,
	revised_by_id			BIGINT			NOT NULL,
	revised_by			VARCHAR(128)		NOT NULL,
	revision_date			DATE			NOT NULL,
	object_version_number           VARCHAR(64)		NOT NULL

);

CREATE TABLE IF NOT EXISTS `trl_role_priv_elements` (

	role_priv_asscn_id		BIGINT			NOT NULL,
	func_priv_name			VARCHAR(64)		NOT NULL,
	data_priv_expr			VARCHAR(2048)

);

CREATE TABLE IF NOT EXISTS `trl_object_privileges` (

	object_priv_id			BIGINT			NOT NULL,
	tenant_id			VARCHAR(128)		NOT NULL,
	object_code			VARCHAR(64)		NOT NULL,
	object_name			VARCHAR(256),
	module_code			VARCHAR(64)		NOT NULL,
	status				VARCHAR(64)		NOT NULL,
	lc_status_chg_date		DATE			NOT NULL,
	enabled_flag			TINYINT(1)		NOT NULL,
	workflow_status			VARCHAR(64),
	wf_status_chg_date		DATE,
	created_by_id			BIGINT			NOT NULL,
	created_by			VARCHAR(128)		NOT NULL,
	creation_date			DATE			NOT NULL,
	revised_by_id			BIGINT			NOT NULL,
	revised_by			VARCHAR(128)		NOT NULL,
	revision_date			DATE			NOT NULL,
	object_version_number           VARCHAR(64)		NOT NULL

);


CREATE TABLE IF NOT EXISTS `trl_obj_priv_elements` (

	object_priv_id			BIGINT			NOT NULL,
	func_priv_name			VARCHAR(64)		NOT NULL,
	data_priv_expr			VARCHAR(2048)

);

