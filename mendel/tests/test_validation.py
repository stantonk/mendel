from unittest import TestCase

from mendel.util import create_host_task


class MendelConfigValidationTest(TestCase):

    def test_cannot_use_both_hostname_and_hostnames(self):
        self.assertRaises(ValueError, create_host_task, 'prod', {'hostname': 'blah', 'hostnames': 'blah,blah2'})

    def test_must_have_hostname_or_hostnames(self):
        self.assertRaises(ValueError, create_host_task, 'prod', {})
